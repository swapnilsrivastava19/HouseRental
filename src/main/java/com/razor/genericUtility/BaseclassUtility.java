package com.razor.genericUtility;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.razor.EnumUtility.ExcelSheet;
import com.razor.EnumUtility.PropertyKeyData;
import com.razor.generic.Base.BaseClassDeclaration;
import com.razor.genericUtility.Listener.ExtentReportListener;
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

public class BaseclassUtility extends BaseClassDeclaration{
	
	@Parameters(value = "browser")
	@BeforeClass(alwaysRun=true)
	public void initializationSetup(@Optional String browser) throws IOException {
		report = ExtentReportListener.sreport;
		propertyUtils=new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		excelUtils= new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		javaUtility=new JavaUtility();
		seleniumUtility=new SeleniumUtility();
		
		waitUtility=new WaitUtility();
		
		
		url= propertyUtils.getPropertyData(PropertyKeyData.URL);
		//if(browser==null||browser.isBlank()||browser.isEmpty()||browser.equals(""))
		if(browser==null)
		{
		browser= propertyUtils.getPropertyData(PropertyKeyData.BROWSER);
		}
		this.browser=browser;
		username= javaUtility.decode(propertyUtils.getPropertyData(PropertyKeyData.USERNAME));
		password= javaUtility.decode(propertyUtils.getPropertyData(PropertyKeyData.PASSWORD));
		timeout= Long.parseLong(propertyUtils.getPropertyData(PropertyKeyData.TIMEOUT));
	}
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		driver = seleniumUtility.launchBrowser(browser,"");
		seleniumUtility.maximizeBrowser();
		screenShotUtility = new ScreenshotUtility(driver);
		waitUtility.WaitForElementLoad(driver, timeout);
		//navigating the app
		seleniumUtility.launchApplication(url);
		//pom class
		adminLogin = new LoginPage(driver);
		homeReg = new HomeRegistrationPage(driver);
		aptReg = new ApartmentRegistrationPage(driver);
		ownerReg = new RegisterOwnerPage(driver);
		homePageLinks = new HomePageLinks(driver);
		adminDashboardLinks = new AdminDashboardPageLinks(driver);
		apartmentList = new ListOfApartment(driver);
		registerPage = new RegisterLinkPage(driver);
		searchPageFields = new SearchPage(driver);
		ownerLoginPage = new OwnerLoginPage(driver);
		ownerDashboardLink = new OwnerDashboardLinks(driver);
		editRoom = new EditRoomPage(driver);
		compPage = new ComplaintPage(driver);
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		seleniumUtility.closeBrowser();
	}
	@AfterClass(alwaysRun=true)
	public void initializationTearDown() throws IOException {
		excelUtils.close();
	}
}
