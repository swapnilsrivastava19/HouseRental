package com.Razor.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.razor.BaseAnnotation.Report;
import com.razor.EnumUtility.ExcelSheet;
import com.razor.genericUtility.BaseclassUtility;
import com.razor.objectRespository.ListOfApartment;

public class Admin_register_room extends BaseclassUtility{
	@Report(author = "Vishwanath")
	@Test
	public void testScipt1() throws InterruptedException, IOException {
		
        //test data
		String sheetName= ExcelSheet.SHEET1.getSheetName();
		String expModuleName="AdminTest";
		String expTestCaseName="IndividualHomeRegistration";
		Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
		System.out.println(map);
		String expFullName=map.get("fullname"); //+" "+javaUtility.getRandomNumber(100);
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
		
		//admin login and register room
		homePageLinks.loginClick();
		adminLogin.loginAction(username, password);
		Assert.assertEquals(adminDashboardLinks.adminPageVerififcation(), "MAHANTESH KUMBAR (ADMIN)");
		adminDashboardLinks.registerClick();
		homeReg.setDataIntoTextField(map);		
		Assert.assertEquals(adminDashboardLinks.successMessage(), "Registration successfull. Thank you"); 
		
		//admin verify registered room
		adminDashboardLinks.homeClick();
		adminDashboardLinks.roomsListClick();
		Assert.assertEquals(apartmentList.apartmentPageVerification(), "List of Apartment Details");		
		Assert.assertEquals(apartmentList.ownerNameVerification(), expFullName);
		adminDashboardLinks.logoutClick();
	}
}




















//PropertyUtility propertyUtils=new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
//ExcelUtility excelUtils= new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
//JavaUtility javaUtility=new JavaUtility();
//SeleniumUtility seleniumUtility=new SeleniumUtility();
//VerificationUtility verificationUtility=new VerificationUtility();
//WaitUtility waitUtility=new WaitUtility();

// common data
//String url=propertyUtils.getPropertyData(PropertyKeyData.URL);
//String browser = propertyUtils.getPropertyData(PropertyKeyData.BROWSER);
//String username = javaUtility.decode(propertyUtils.getPropertyData(PropertyKeyData.USERNAME));
//String password = javaUtility.decode(propertyUtils.getPropertyData(PropertyKeyData.PASSWORD));
//long timeout = Long.parseLong(propertyUtils.getPropertyData(PropertyKeyData.TIMEOUT));

//WebDriver driver = seleniumUtility.launchBrowser(browser,"");
	//	InteractionUtility interactionUtility=new InteractionUtility(driver);

////calling POM class
//LoginPage login=new LoginPage(driver);
//HomeRegistrationPage homeRegister=new HomeRegistrationPage(driver);
//login.loginAction(username, password);

		//pre setting the browser
	//	seleniumUtility.maximizeBrowser();
	//	waitUtility.WaitForElementLoad(driver, timeout);

//		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		driver.findElement(By.xpath("//h2[.='Register Room']/../form/div[6]/following-sibling::button")).click();

//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='fullname']")).sendKeys(expFullName);
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='mobile']")).sendKeys(map.get("mobile"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='alternat_mobile']")).sendKeys(map.get("alternat_mobile"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='email']")).sendKeys(map.get("email"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='plot_number']")).sendKeys(map.get("plot_number"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='rooms']")).sendKeys(map.get("rooms"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='country']")).sendKeys(map.get("country"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='state']")).sendKeys(map.get("state"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='city']")).sendKeys(map.get("city"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='rent']")).sendKeys(map.get("rent"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).sendKeys(map.get("sale"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='deposit']")).sendKeys(map.get("deposit"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='landmark']")).sendKeys(map.get("landmark"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='address']")).sendKeys(map.get("address"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='image']")).sendKeys(map.get("image"));
//		driver.findElement(By.xpath("//h2[.='Register Room']/../form/div[6]/following-sibling::button")).click();

//		if(success.getText().equals("Registration successfull. Thank you"))
//		{
//			System.out.println("message : "+ success.getText());
//			System.out.println("verification successful");
//			driver.close();
//		}
//		else
//		{
//			System.out.println("defect");
//		}

//List<WebElement>list = driver.findElements(By.xpath("//h4[.='Owner Details']/../p[1]"));
//String actualFullName = "";
//for(WebElement ele1:list)
// { 
//	 actualFullName =ele1.getText().replaceAll("Owner Name: ","");
// } 

// Assert.assertEquals(actualFullName, expFullName, "TC is Pass");
// driver.findElement(By.xpath("//a[.='Logout']")).click();

/*
 * driver.findElement(By.xpath("(//button[.='Submit'])[1]")).click();
 * driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("tommy");
 * driver.findElement(By.xpath("(//input[@title='10 digit mobile number'])[1]"))
 * .sendKeys("8974561250");
 * driver.findElement(By.xpath("(//input[@title='10 digit mobile number'])[2]"))
 * .sendKeys("3698521470");
 * driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys(
 * "tommy@razor.com");
 * driver.findElement(By.xpath("(//input[@id='plot_number'])[1]")).sendKeys(
 * "3781");
 * driver.findElement(By.xpath("//input[@id='rooms']")).sendKeys("4bhk");
 * driver.findElement(By.xpath("(//input[@id='country'])[1]")).sendKeys("India")
 * ; driver.findElement(By.xpath("(//input[@id='state'])[1]")).sendKeys("goa");
 * driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("panaji");
 * driver.findElement(By.xpath("//input[@id='rent']")).sendKeys("8000");
 * driver.findElement(By.xpath("//input[@id='sale']")).sendKeys("7880000");
 * driver.findElement(By.xpath("//input[@id='deposit']")).sendKeys("45000");
 * driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys(
 * "forest"); driver.findElement(By.xpath("(//input[@id='address'])[1]")).
 * sendKeys("123 stone park"); WebElement ele =
 * driver.findElement(By.xpath("(//input[@id='image'])[1]"));
 * ele.sendKeys("C:\\MANUAL ASSIGN\\WB.png");
 * driver.findElement(By.xpath("(//button[.='Submit'])[1]")).click();
 */
//seleniumUtility.closeBrowser();