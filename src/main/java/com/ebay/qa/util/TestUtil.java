package com.ebay.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ebay.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;   // both public so that can be used anywhere
	public static long IMPLICIT_WAIT = 10; 
	
//	public static String TESTDATA_SHEET_PATH = "C:\\Selenium_Workspace\\PageObjectModelEbay\\src\\main\\java\\com\\ebay\\qa\\testdata\\EbayTestData.xlsx";
	
	
	// Also we can create a Frame Switch Method in util class
//	public void switchToFrame() {     
//		driver.switchTo.frame("XYZ frame name or index no");                           // if we wanna use "driver" then this class also extends TestBase class 
//	}
	
//	public static void getTestData(String sheetName) {
//		FileInputStream file =null;
//		file = new FileInputStream(TESTDATA_SHEET_PATH);
//	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);                // extends testbase for driver
		FileUtils.copyFile(scrFile, new File("C:\\Selenium_Workspace\\PageObjectModelEbay" + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
	
	}

}
