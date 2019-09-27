package com.lyh.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zte.lyh.PluginParamsConfig;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class AutoCreateRestAndServiceUtil {

	public static Configuration configuration;
	static List<String> mode = new ArrayList<String>();
	static List<String> modeExample = new ArrayList<String>();
	public static Template t;
	public static Template t0;
	private static PluginParamsConfig p;
	static {
		configuration = new Configuration(new Version("2.3.29"));
		configuration.setClassForTemplateLoading(AutoCreateRestAndServiceUtil.class, "/template");
		try {
			t = configuration.getTemplate("controller.tpl");
			t0 = configuration.getTemplate("service.tpl");
		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 动态生成rest
	 * 
	 * @param p
	 * 
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createRest(PluginParamsConfig porp) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		p = porp;
		getFileList();
		mode.stream().forEach(model -> {
			try {
				loadServiceClass(model);
				loadClass(model);
			} catch (InstantiationException | IllegalAccessException | IOException | TemplateException e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * 生成bean对应的rest
	 * 
	 * @param name
	 *            bean文件名
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws TemplateException
	 */
	public static void loadClass(String name)
			throws IOException, InstantiationException, IllegalAccessException, TemplateException {
		// 读取本地的class文件内的字节码，转换成字节码数组
		Map<String, String> map = new HashMap<String, String>();
		map.put("model", name);
		String service = name + "ServiceImpl";
		map.put("service", service);
		map.put("example", name + "Example");
		map.put("class", name + "Rest");
		map.put("mapping", name.substring(0, 1).toLowerCase() + name.substring(1, name.length()));
		map.put("service1", service.substring(0, 1).toLowerCase() + service.substring(1, service.length()));
		String classpath = p.getClassPath();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(classpath + name + ".class"));
		byte[] result = new byte[1024 * 100];
		int len = bis.read(result);
		bis.close();
		// 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
		MyClassLoader loader = new MyClassLoader();
		Class clazz = loader.defineMyClass(result, 0, len);
		ApiModel apiModel = (ApiModel) clazz.getAnnotation(ApiModel.class);
		map.put("tags", apiModel.value());
		String apiName = new String();
		try {
			// 获取bean上所有属性值
			int count = 0;
			Field[] files = clazz.getDeclaredFields();
			for (Field file : files) {
				file.setAccessible(true);
				String fileName = file.getName();
				String typeName = file.getType().getTypeName();
				ApiModelProperty property = file.getAnnotation(ApiModelProperty.class);
				if (property == null) {
					continue;
				}
				String propertyValue = property.value();
				String line = "";
				if (count != 0) {
					line = "    ";
				}
				apiName += line + "@ApiImplicitParam(paramType =\"query\"" + ",name=" + "\"" + fileName + "\""
						+ ",value=" + "\"" + propertyValue + "\"" + ",required = false" + ",dataType=" + "\"" + typeName
						+ "\"),\r\n";
				count++;
			}
			String api = apiName.substring(0, apiName.length() - 1);
			map.put("ApiImplicitParam", api);
			// 调用Programmer的code方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		String restpath = p.getRestPath();
		t.process(map, new PrintWriter(new FileWriter(new File(restpath, name + "Rest.java"))));
	}

	public static void loadServiceClass(String name)
			throws IOException, InstantiationException, IllegalAccessException, TemplateException {
		// 读取本地的class文件内的字节码，转换成字节码数组
		Map<String, String> map = new HashMap<String, String>();
		map.put("model", name);
		String mapper = name + "Mapper";
		map.put("mapper", mapper);
		map.put("example", name + "Example");
		map.put("serviceClass", name + "Example");
		map.put("mapper1", mapper.substring(0, 1).toLowerCase() + mapper.substring(1, mapper.length()));
		String classpath = p.getClassPath();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(classpath + name + ".class"));
		byte[] result = new byte[1024 * 100];
		int len = bis.read(result);
		bis.close();
		// 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
		MyClassLoader loader = new MyClassLoader();
		Class clazz = loader.defineMyClass(result, 0, len);
		String params = new String();
		try {
			// 获取bean上所有属性值
			Field[] files = clazz.getDeclaredFields();
			for (Field file : files) {
				file.setAccessible(true);
				String fileName = file.getName();
				ApiModelProperty property = file.getAnnotation(ApiModelProperty.class);
				if (property == null) {
					continue;
				}
				String propertyValue = property.value();
				params += "\r\n        //" + propertyValue + "\r\n";
				String upname = fileName.substring(0, 1).toUpperCase() + fileName.substring(1, fileName.length());
				String param2 = "item.get" + upname + "()";
				String p = null;
				if (file.getType().equals(String.class)) {
					p = "        if(StringUtils.isNotEmpty(" + param2 + ")){\r\n          criteria.and" + upname
							+ "EqualTo(" + "\"%\"+" + param2 + "+\"%\");\r\n        }";

				} else {
					p = "        if(" + param2 + "!=null){\r\n           criteria.and" + upname + "EqualTo(" + param2
							+ ");\r\n        }";
				}
				params += p;
			}
			map.put("params", params);
			map.put("serviceClass", name + "ServiceImpl");

			// 调用Programmer的code方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		String servicepath = p.getServicePath();
		t0.process(map, new PrintWriter(new FileWriter(new File(servicepath, name + "ServiceImpl.java"))));

	}

	/**
	 * 自定义一个类加载器，用于将字节码转换为class对象
	 * 
	 * @author louluan
	 */
	public static class MyClassLoader extends ClassLoader {

		public Class<?> defineMyClass(byte[] b, int off, int len) {
			return super.defineClass(b, off, len);
		}

	}

	/*
	 * 读取指定路径下的文件名和目录名
	 */
	public static void getFileList() {
		List<File> list = AutoCreateBeanUtil.files;
		list.stream().forEach(f -> {
			mode.add(f.getName().split("\\.")[0]);
		});
	}

}
