package com.razor.genericUtility.Misc;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.razor.genericUtility.FrameworkConstants;


/**
 * This class is used to generate report and configure report page
 * @author Vishwanath-Naik
 *
 */
public class ReportUtility {

	private ExtentReports report;
	private String extentFileReportPath;
	/**
	 * 
	 * @param filePath
	 * @param title
	 * @param reportName
	 * @param browserName
	 */
	public void init(String filePath, String title, String reportName, String browserName)
	{
		extentFileReportPath="FrameworkConstants.EXTENT_REPORTS_PATH+\"extentReport\"+filePath+\".html\"";
		ExtentSparkReporter spark = new ExtentSparkReporter( extentFileReportPath);
		spark.config().setDocumentTitle(title);
		spark.config().setReportName(reportName);
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", browserName);
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}
    /**
     * 
     * @param testName
     */
	public void createTest(String testName)
	{
		ExtentTest test = report.createTest(testName);
		UtilityInstanceTransfer.setExtentTest(test);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 * @param errorMessage
	 */
	public void fail(ExtentTest test, String message, Throwable errorMessage)
	{
		test.fail(message);
		test.fail(errorMessage);
		System.out.println(message);
	}
	/**
	 * 
	 * @param test
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names)
	{
		test.assignAuthor(names);

	}
	/**
	 * 
	 * @param test
	 * @param names
	 */
	public void addCategory(ExtentTest test, String... names)
	{
		test.assignCategory(names);

	}
    /**
     * 
     * @param test
     * @param message
     */
	public void pass(ExtentTest test, String message)
	{
		test.pass(message);
		System.out.println(message);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	public void warn(ExtentTest test, Throwable message)
	{
		test.warning(message);
		System.out.println(message);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 * @param errorMessage
	 */
	public void skip(ExtentTest test, String message, Throwable errorMessage)
	{
		test.skip(message);
		test.skip(errorMessage);
		System.out.println(message);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	public void info(ExtentTest test, String message)
	{
		test.info(message);
		System.out.println(message);
	}
    /**
     * 
     * @param test
     * @param screenshotPath
     * @param title
     * @param strategy
     */
	public void attachScreenshot(ExtentTest test, String screenshotPath, String title, String strategy)
	{
		if(strategy.equalsIgnoreCase("base64"))
		{
			test.addScreenCaptureFromBase64String(screenshotPath, title);
		}
		else
		{
			test.addScreenCaptureFromPath(screenshotPath, title);
		}
	}
	/**
	 * 
	 */
	public void saveReport()
	{
		report.flush();
		try {
			Desktop.getDesktop().browse(new File(extentFileReportPath).toURI());
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}

}
