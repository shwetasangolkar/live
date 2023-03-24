package com.sauce.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataFromExcel {
		
		static String testdatapath="C:\\Users\\rohit\\OneDrive\\Desktop\\Book9.xlsx";
		static Workbook book;      
	    static Sheet sheet;

		public static Object[][] getTestData(String sheetName)
		{
			FileInputStream file = null;
			try
			{
				file=new FileInputStream(testdatapath);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				book=WorkbookFactory.create(file);
			}
			catch(IOException i)
			{
				i.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			sheet=book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
		}
		
		public String readExcel(int sheetNumber,int rowNumber,int columnNumber) 
		{
			String data = null;
			try {
			FileInputStream fis = new FileInputStream(testdatapath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1=wb.getSheetAt(sheetNumber);
			data=sheet1.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
			FileOutputStream fos = new FileOutputStream(testdatapath);
		    fos.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return data;
		}
		
	}


