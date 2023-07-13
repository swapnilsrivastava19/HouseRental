package com.Razor.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.razor.BaseAnnotation.Report;
import com.razor.EnumUtility.ExcelSheet;
import com.razor.genericUtility.BaseclassUtility;
@Listeners()
public class Admin_create_apartment_and_search extends BaseclassUtility {
	
	@Report(author = "Vishwanath")
	@Test
	public void testScript2() throws IOException {
		
		//test data
		String sheetName= ExcelSheet.SHEET1.getSheetName();
		String expModuleName="AdminTest";
		String expTestCaseName="Apartment Registration";
		Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
		System.out.println(map);
		String expApartmentName=map.get("apartment_name"); //+" "+javaUtility.getRandomNumber(100);		
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
		
		//admin login
		homePageLinks.loginClick();
		adminLogin.loginAction(username, password);
		Assert.assertEquals(adminDashboardLinks.adminPageVerififcation(), "MAHANTESH KUMBAR (ADMIN)");
		
		//admin register apartment
		adminDashboardLinks.registerClick();
		registerPage.apartmentRegistrationClick();
		aptReg.setDataIntoTextField(map);
		Assert.assertEquals(adminDashboardLinks.successMessage(),"Registration successfull. Thank you");
		adminDashboardLinks.logoutClick();
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
		
		//search and verify
		homePageLinks.searchClick();
		searchPageFields.SearchAction(map.get("rooms"), map.get("city"));
		searchPageFields.searchClick();
		Assert.assertEquals(searchPageFields.apartmentNameVerification(), expApartmentName);
	}
}















//driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
//driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
//driver.findElement(By.xpath("//button[@type='submit']")).click();

//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='apartment_name']")).sendKeys(expApartmentName);
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='mobile']")).sendKeys(map.get("mobile"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='alternat_mobile']")).sendKeys(map.get("alternat_mobile"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='email']")).sendKeys(map.get("email"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='plot_number']")).sendKeys(map.get("plot_number"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='country']")).sendKeys(map.get("country"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='state']")).sendKeys(map.get("state"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='city']")).sendKeys(map.get("city"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='landmark']")).sendKeys(map.get("landmark"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='address']")).sendKeys(map.get("address"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='image']")).sendKeys(map.get("image"));
//
//driver.findElement(By.xpath("//a[.='Add More(Plat Number/Description)']")).click();
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='fullname']")).sendKeys(map.get("fullname"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='ap_number_of_plats']")).sendKeys(map.get("ap_number_of_plats"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='rooms']")).sendKeys(map.get("rooms"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='area']")).sendKeys(map.get("area"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='rent']")).sendKeys(map.get("rent"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='deposit']")).sendKeys(map.get("deposit"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='accommodation']")).sendKeys(map.get("accomodation"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='description']")).sendKeys(map.get("description"));
//driver.findElement(By.xpath("//h2[.='Apartment Room']/../form/div[6]/following-sibling::button")).click();
//driver.findElement(By.xpath("//a[.='Search']")).click();
//driver.findElement(By.xpath("//input[@id='keywords']")).sendKeys(map.get("rooms"));
//driver.findElement(By.xpath("//input[@id='location']")).sendKeys(map.get("city")); 
//driver.findElement(By.xpath("//button[@name='search']")).click();
//List<WebElement> list = driver.findElements(By.xpath("//h4[.='Room Details']/..//div[1]/p"));
//String actualApartmentName="";
//for(WebElement ele:list)
//{
//	actualApartmentName = ele.getText().replaceAll("Apartment Name: ","");
//}