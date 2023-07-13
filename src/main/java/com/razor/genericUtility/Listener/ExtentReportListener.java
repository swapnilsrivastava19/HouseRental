package com.razor.genericUtility.Listener;


import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.razor.BaseAnnotation.Report;
import com.razor.EnumUtility.PropertyKeyData;
import com.razor.genericUtility.BaseclassUtility;
import com.razor.genericUtility.FrameworkConstants;
import com.razor.genericUtility.JavaUtility;
import com.razor.genericUtility.PropertyUtility;
import com.razor.genericUtility.Misc.ReportUtility;
import com.razor.genericUtility.Misc.UtilityInstanceTransfer;

/**
 * This class will generate report at the end of execution
 * @author Vishwanath-Naik
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener{
	
	private ReportUtility report;
	public static ReportUtility sreport;
	
	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("onStart ----> Suite");
		PropertyUtility propertyutility;
	    propertyutility = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
	    report = new ReportUtility();
	    String overrideOrNot=propertyutility.getPropertyData(PropertyKeyData.OVERRIDERREPORT);
	    String randomName="";
	    if(overrideOrNot.equalsIgnoreCase("no"))
	    randomName = "-"+ new JavaUtility().getCurrentDate();
	    report.init(randomName, propertyutility.getPropertyData(PropertyKeyData.EXTENTREPORTTITLE), propertyutility.getPropertyData(PropertyKeyData.EXTENTREPORTNAME), propertyutility.getPropertyData(PropertyKeyData.BROWSER));
		sreport = report;
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		System.out.println("onFinish ----> Suite");
		report.saveReport();
	}


	
	@Override
	public void onTestStart(ITestResult result) //BM
	{

		System.out.println("onTestStart");

		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}


	@Override
	public void onTestSuccess(ITestResult result) { //AM
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) { //AM
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed", result.getThrowable());
		String screenshotPath = BaseclassUtility.class.cast(result.getMethod().getInstance()).screenShotUtility.capture();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(), screenshotPath, result.getMethod().getMethodName(), "base64");
	}

	@Override
	public void onTestSkipped(ITestResult result) { //AM
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed", result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { //AM
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) { //AM
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context)  //BT
	{
		System.out.println("onStart---> Test");
		
	}

	@Override
	public void onFinish(ITestContext context) { //AT
		System.out.println("onFinish ---> Test");
		report.saveReport();
	}

	

}
