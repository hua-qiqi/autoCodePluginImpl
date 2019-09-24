package com.zte.common.util;

import java.io.IOException;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
	
	public static String getValue(String fileName, String key) {
		String value = null;
		try {
			value = PropertiesLoaderUtils.loadAllProperties(fileName).getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
