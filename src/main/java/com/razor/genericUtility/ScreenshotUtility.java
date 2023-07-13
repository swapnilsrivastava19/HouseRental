package com.razor.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * in this class we take screeshot of failed test case
 * @author Vishwanath-Naik
 *
 */
public class ScreenshotUtility {
	private WebDriver driver;
	
	public ScreenshotUtility(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * this method is used to capture image of webpage whenever test case is failed
	 * @param driver
	 * @param name
	 * @return 
	 * @throws IOException 
	 */
	public String capture(String testCaseName,JavaUtility javaUtility) throws IOException {
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(FrameworkConstants.TEST_SCREENSHOT_PATH+testCaseName+"_"+javaUtility.getCurrentDate()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * 
	 * @return
	 */
	public String capture() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path=ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	/**
	 * this method will take screenshot of webelement whenever test case failed
	 * @param ele
	 * @param name
	 * @return 
	 * @throws IOException 
	 */
	public String capture(WebElement ele, String elementName, JavaUtility javaUtility) throws IOException {
		
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst = new File(FrameworkConstants.TEST_SCREENSHOT_PATH+elementName+"_"+javaUtility.getCurrentDate()+".png");
		try {
			FileUtils.copyFile(src, dst);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();
	}
	
}
