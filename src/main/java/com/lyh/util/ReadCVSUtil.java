package com.lyh.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadCVSUtil{

	private static XSSFWorkbook hssfWorkbook;

	public static Map<String, Map<String,String>> readCVS() throws FileNotFoundException, IOException {

		hssfWorkbook = new XSSFWorkbook(new FileInputStream(PropertiesUtil.getValue("FileParams.properties", "file.path")));
		// 2.获取要解析的表格（第一个表格）
		XSSFSheet sheet = hssfWorkbook.getSheetAt(0);
		Map<String, Map<String,String>> map = new HashMap<String,  Map<String,String>>();
		
		// 获得最后一行的行号
		int lastRowNum = sheet.getLastRowNum();
		String stringCellValue0=null;
		Map<String,String> wordList=null;
		// List<String> beanNameList=new ArrayList<String>();
		// List<String> beanParamsList=new ArrayList<String>();
		// List<String> wordList=new ArrayList<String>();
		// List<Integer> rowsList=new ArrayList<Integer>();
		for (int i = 1; i <= lastRowNum; i++) {// 遍历每一行
			// 3.获得要解析的行
			XSSFRow row = sheet.getRow(i);
			double stringCellValue2 = row.getCell(2).getNumericCellValue();
			// 4.获得每个单元格中的内容（String）
			String stringCellValue12 = row.getCell(12).getStringCellValue();
			
			String stringCellValue3 = row.getCell(3).getStringCellValue();
			
			if(stringCellValue2==1 && i == 1) {
				if( row.getCell(0)!=null) {
					stringCellValue0 = row.getCell(0).getStringCellValue();
				}
				wordList = new HashMap<>();
			}
			
			if (stringCellValue2==1 && i != 1) {
				map.put(stringCellValue0, wordList);
				wordList =new HashMap<>();
				if( row.getCell(0)!=null) {
					stringCellValue0 = row.getCell(0).getStringCellValue();
				}
			}
			wordList.put(stringCellValue3, stringCellValue12);
			if(i==lastRowNum) {
				map.put(stringCellValue0, wordList);
			}
		}
		return map;

	}

}
