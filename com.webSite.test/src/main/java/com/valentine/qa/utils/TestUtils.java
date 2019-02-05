package com.valentine.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtils {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICTLY_WAIT = 20;

	static String TEST_DATA_PATH = "/home/manish/git/com.valentine.automationTest/com.webSite.test"
			+ "/src/main/java/com/valentine/qa/testdata/testDataValentine.xlsx";

	static Workbook workbook;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TEST_DATA_PATH);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		
		//sheet.getLastRowNum(); 		sheet.getRow(0).getLastCellNum();		sheet.getRow(0).getCell(0).toString();
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int row=0; row<sheet.getLastRowNum(); row++) {
			for(int col=0; col<sheet.getRow(0).getLastCellNum(); col++) {
				data[row][col] = sheet.getRow(row+1).getCell(col).toString();
			}
		}
		return data;
		

	}
}
