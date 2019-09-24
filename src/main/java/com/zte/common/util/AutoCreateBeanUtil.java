package com.zte.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class AutoCreateBeanUtil {

	
	/**
	 * 指定目录下的bean文件生成注解
	 * @throws IOException
	 */
	public static void autoCreateAnntation() throws IOException {
		File file = new File(PropertiesUtil.getValue("FileParams.properties", "bean.path"));
		File[] fileList = file.listFiles();
		//通过数据库字典excel读取注解属性
 		Map<String, List<String>> map = ReadCVSUtil.readCVS();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				String fileName = fileList[i].getName();
				String[] name = fileName.split("\\.");
				if (name[0].endsWith("Example")) {
					continue;
				}

				for (String key : map.keySet()) {
					if (key.split("\\|")[0].replaceAll("_", "").toLowerCase().equals(name[0].toLowerCase())) {
						readFile(fileList[i], map.get(key), key.split("\\|")[1]);
					}
				}

			}

		}
		List<File> sourceFiles = new ArrayList<File>();
		String targetpath=PropertiesUtil.getValue("FileParams.properties", "target.path");
		//自动编译bean文件，为后续反射获取bean属性做准备
		compiler(file,targetpath,sourceFiles);
		compilerJavaFile(sourceFiles,targetpath);

	}

	/**
	 * bean文件添加swagge注解
	 * @param file 目标java文杰
	 * @param apiName 类注解
	 * @param list 字段注释
	 * @throws IOException
	 */
	public static void readFile(File file, List<String> list, String apiName) throws IOException {
		List<String> temp = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(file);
		int index = 0;
		// 设置inputStreamReader的构造方法并创建对象设置编码方式为gbk
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			if (str.trim().startsWith("public class")) {
				temp.add("import io.swagger.annotations.ApiModelProperty;");
				temp.add("import io.swagger.annotations.ApiModel;");
				temp.add("        ");
				temp.add("@ApiModel(" +"\""+ apiName +"\""+")");
			}
			if (str.trim().startsWith("private") && !str.trim().startsWith("private static")) {
				temp.add("    @ApiModelProperty(value =" +"\""+ list.get(index) +"\""+ ")");
				index++;
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

	}

	/**
	 * 递归获取java文件
	 * 
	 * @param file
	 *            需要编译的文件夹
	 * @param targetPath
	 *            编译后class类文件存放目录
	 */
	public static void compiler(File file, String targetPath, List<File> sourceFiles) {
		File targetDir = new File(targetPath);
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		if (file != null && file.exists()) {
			File[] listFiles = file.listFiles();
			if (null == listFiles || listFiles.length == 0) {
				return;
			}
			for (File file2 : listFiles) {

				if (file2.isDirectory()) {
					compiler(file2, targetPath, sourceFiles);
				} else {
					if (file2.getName().endsWith(".java")) {
						// 将源文件目录中的Java文件加入集合中
						sourceFiles.add(file2);
					}
				}
			}
		} else {
			System.out.println("传入格式未知文件");
		}
	}

	/**
	 * 编译java文件
	 * 
	 * @param sourcePath
	 * @param targerPath
	 * @return
	 */
	public static boolean compilerJavaFile(List<File> sourceFile, String targerPath) {
        JavaCompiler comp = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = comp.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> compilationUnits = fileMgr.getJavaFileObjectsFromFiles(sourceFile);
		List<String> options = new ArrayList<String>();
        options.add("-d");
        options.add(targerPath);
		return comp.getTask(null, fileMgr, null, options, null, compilationUnits).call();

	}

}
