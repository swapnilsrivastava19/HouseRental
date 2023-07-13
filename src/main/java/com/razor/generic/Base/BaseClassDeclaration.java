package com.razor.generic.Base;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.razor.genericUtility.ExcelUtility;
import com.razor.genericUtility.JavaUtility;
import com.razor.genericUtility.PropertyUtility;
import com.razor.genericUtility.ScreenshotUtility;
import com.razor.genericUtility.Misc.ReportUtility;
import com.razor.genericUtility.WebAction.SeleniumUtility;
import com.razor.genericUtility.WebAction.WaitUtility;
import com.razor.objectRespository.AdminDashboardPageLinks;
import com.razor.objectRespository.ApartmentRegistrationPage;
import com.razor.objectRespository.ComplaintPage;
import com.razor.objectRespository.EditRoomPage;
import com.razor.objectRespository.HomePageLinks;
import com.razor.objectRespository.HomeRegistrationPage;
import com.razor.objectRespository.ListOfApartment;
import com.razor.objectRespository.LoginPage;
import com.razor.objectRespository.OwnerDashboardLinks;
import com.razor.objectRespository.OwnerLoginPage;
import com.razor.objectRespository.RegisterLinkPage;
import com.razor.objectRespository.RegisterOwnerPage;
import com.razor.objectRespository.SearchPage;
/**
 * 
 * @author Vishwanath-Naik
 *
 */
public class BaseClassDeclaration {
	protected PropertyUtility propertyUtils;
	protected ExcelUtility excelUtils;
	public JavaUtility javaUtility;
	public SeleniumUtility seleniumUtility;
	protected WaitUtility waitUtility;
	protected String url;
	protected String browser;
	protected String username;
	protected String password;
	protected long timeout;
	public WebDriver driver;
	protected Map<String, String> map;
	protected String expFullName;
	protected String sheetName;
	protected String expModuleName;
	protected String expTestCaseName;
	protected LoginPage adminLogin;
	protected HomeRegistrationPage homeReg;
	protected ApartmentRegistrationPage aptReg;
	protected RegisterOwnerPage ownerReg;
	protected HomePageLinks homePageLinks;
	protected AdminDashboardPageLinks adminDashboardLinks;
	protected ListOfApartment apartmentList;
	protected RegisterLinkPage registerPage;
	protected SearchPage searchPageFields;
	protected OwnerLoginPage ownerLoginPage;
	protected OwnerDashboardLinks ownerDashboardLink;
	protected EditRoomPage editRoom;
	protected ComplaintPage compPage;
	protected ReportUtility report;
	public ExtentTest test;
	public ScreenshotUtility screenShotUtility;
}
