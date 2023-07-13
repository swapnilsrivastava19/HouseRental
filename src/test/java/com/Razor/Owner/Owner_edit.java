package com.Razor.Owner;

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

public class Owner_edit extends BaseclassUtility {
	@Report(author = "Vishwanath")
	@Test
	public void testScript3() throws IOException {

		//test data
		String sheetName= ExcelSheet.SHEET1.getSheetName();
		String expModuleName="OwnerTest";
		String expTestCaseName="EditOwner";
		Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
		System.out.println(map);
		String expSale=map.get("sale"); //+javaUtility.getRandomNumber(100);
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
		
		//owner login
		homePageLinks.loginClick();
		Assert.assertEquals(ownerLoginPage.loginPageVerification(), "Login");
		ownerLoginPage.ownerloginAction(map.get("username"), map.get("password"));
		Assert.assertEquals(ownerDashboardLink.ownerPageVerification(), "Dash board");

		//owner update
		ownerDashboardLink.detailsClick();
		ownerDashboardLink.editClick();
		editRoom.editAction(expSale, map.get("accommodation"), map.get("description"),map.get("other"));
		ownerDashboardLink.logoutClick();
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");

		//admin login
		homePageLinks.loginClick();
		Assert.assertEquals(adminLogin.loginPageVerify(), "Login");
		adminLogin.loginAction(username, password);
		adminDashboardLinks.detailsClick();
		Assert.assertEquals(apartmentList.apartmentPageVerification(), "List of Apartment Details"); 
		
		//verify edited sale
		Assert.assertEquals(apartmentList.saleListVerification(expSale),expSale);
		adminDashboardLinks.logoutClick();		
	}
}



















//		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();


	//		driver.findElement(By.xpath("//div/h4[.='Other Details']/../div//b"));
	//		WebElement text = driver.findElement(By.xpath("//div/h4[.='Other Details']/../div//b"));
	//		System.out.println(text);
	//		driver.findElement(By.xpath("//a[.='Edit']")).click();

//driver.findElement(By.xpath("//a[.='Details/Update']")).click();
//driver.findElement(By.xpath("//a[.='Edit']")).click();
//driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).clear();
//driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).sendKeys(expSale);
//driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).clear();
//driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='description']")).clear();
//driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).sendKeys(map.get("accommodation"));
//driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='description']")).sendKeys(map.get("description"));
//driver.findElement(By.xpath("//input[@type='other']")).sendKeys(map.get("other"));
//driver.findElement(By.xpath("//button[@type='submit']")).click();
//driver.findElement(By.xpath("//a[.='Logout']")).click();
//String homePage2=driver.getCurrentUrl();
//if(homePage2.equals("http://rmgtestingserver/domain/House_Rental_Application/index.php"))
//{
//	System.out.println("home page is displayed after owner logout");
//}
//
