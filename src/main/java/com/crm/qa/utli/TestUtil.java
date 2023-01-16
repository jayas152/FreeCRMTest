package com.crm.qa.utli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static long pageLoad = 20;
	public static long implicitlyWait = 20;
	public static long ecplictiWait = 5;
	public static String TESTDATA_SHEET_PATH = "/Users/jayas/Desktop/Selenium_WorkSpace/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmData.xlsx";
	static Workbook book;
	static Sheet sheet;
	// sheet = new Sheet("daa");

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");	
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("Sheet1");
	     Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

	     for (int i =0; i <sheet.getLastRowNum();i++){

	         for (int k =0;k <sheet.getRow(0).getLastCellNum(); k++){
	             data[i][k]= sheet.getRow(i+1).getCell(k).toString();

	         }
	     }

	     return data;

	}


	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	

	
	
	
}
