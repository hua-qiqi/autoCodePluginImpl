package com.lyh.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import com.zte.lyh.PluginParamsConfig;

public class AutoCreateBeanUtil {

	private static BufferedReader bufferedReader;
	public static List<File> files = new ArrayList<>();

	/**
	 * 指定目录下的bean文件生成注解
	 * 
	 * @param p
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void autoCreateAnntation(PluginParamsConfig p)
			throws IOException, ClassNotFoundException, SQLException {
		File file = new File(p.getBeanPath());
		File[] fileList = file.listFiles();
		// 通过数据库字典excel读取注解属性
		// Map<String, List<String>> map = ReadCVSUtil.readCVS();
		Map<String, Map<String, String>> map = ReadDBUtil.paraseDBInfo2Map(p);
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				String fileName = fileList[i].getName();
				String[] name = fileName.split("\\.");
				if (name[0].endsWith("Example")) {
					continue;
				}

				for (String key : map.keySet()) {
					if (key.equals(name[0].toLowerCase())) {
						readFile(fileList[i], map.get(key), key);
					}
				}

			}

		}
		String targetpath = p.getTargetPath();
		// 自动编译bean文件，为后续反射获取bean属性做准备
		compilerJavaFile(files, targetpath);

	}

	/**
	 * bean文件添加swagge注解
	 * 
	 * @param file
	 *            目标java文杰
	 * @param apiName
	 *            类注解
	 * @param map
	 *            字段注释
	 * @throws IOException
	 */
	public static void readFile(File file, Map<String, String> map, String apiName) throws IOException {
		List<String> temp = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(file);
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			if (str.contains("lyhcheck=true")) {
				return;
			}
			if (str.trim().startsWith("package")) {// 加上已经处理的标志
				temp.add("//lyhcheck=true");
			}
			if (str.trim().startsWith("public class")) {
				temp.add("import io.swagger.annotations.ApiModelProperty;");
				temp.add("import io.swagger.annotations.ApiModel;");
				temp.add("import io.swagger.annotations.ApiParam;");
				temp.add("        ");
				temp.add("@ApiModel(" + "\"" + apiName + "\"" + ")");
			}

			if (str.trim().startsWith("private") && !str.trim().startsWith("private static")) {
				for (String key : map.keySet()) {
					if (str.toLowerCase().contains(key)) {
						temp.add("    @ApiModelProperty(value =" + "\"" + map.get(key) + "\"" + ")");
						temp.add("     @ApiParam(value =" + "\"" + map.get(key) + "\"" + ")");
						
					}
				}

			}
			temp.add(str);
		}
		// close
		inputStream.close();
		bufferedReader.close();

		// 下面按行读。我实现的其实就是变相的分行打印，如果有更好的方法请大家指教
		OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		BufferedWriter bw = new BufferedWriter(os);
		PrintWriter out = new PrintWriter(bw);
		for (String aTemp : temp) {
			out.println(aTemp);
		}
		bw.close();
		os.close();
		out.close();
		files.add(file);
	}

	/**
	 * 编译java文件
	 * 
	 * @param sourcePath
	 * @param targerPath
	 * @return
	 */
	public static void compilerJavaFile(List<File> sourceFile, String targerPath) {
		if (sourceFile.size() > 0) {
			JavaCompiler comp = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileMgr = comp.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> compilationUnits = fileMgr.getJavaFileObjectsFromFiles(sourceFile);
			List<String> options = new ArrayList<String>();
			options.add("-d");
			options.add(targerPath);
			comp.getTask(null, fileMgr, null, options, null, compilationUnits).call();
		}

	}

}
