package com.razor.genericUtility.Misc;

import com.aventstack.extentreports.ExtentTest;
/**
 * 
 * @author Vishwanath-Naik
 *
 */
public class UtilityInstanceTransfer {
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	/**
	 * 
	 * @return
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	/**
	 * 
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest.set(setExtentTest);
	}
}
