package com.razor.genericUtility;
/**
 * this class contains path of property file,excel sheet and screenshot
 * @author Vishwanath-Naik
 *
 */
public interface FrameworkConstants {
	
	String TEST_PROPERTY_FILE_PATH = "./src/test/resources/propertyData/razor.properties";
		
	String TEST_EXCEL_FILE_PATH = "./src/test/resources/excelData/ProjectData.xlsx";
	
	String TEST_SCREENSHOT_PATH = "./src/test/resources/screenshot";
	
	String EXTENT_REPORTS_PATH = System.getProperty("user.dir")+"Reports/";
}
