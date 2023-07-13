package com.Razor.Owner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.razor.EnumUtility.ExcelSheet;
import com.razor.genericUtility.BaseclassUtility;

public class RegisterOwnerApartmentEdit extends BaseclassUtility{

	@Test
	public void testScript4() throws IOException {

		//test data
		String sheetName= ExcelSheet.SHEET1.getSheetName();
		String expModuleName="OwnerTest";
		String expTestCaseName="RegisterNewOwner";
		Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
		System.out.println(map);
		String expModuleName1="AdminTest";
		String expTestCaseName1="Apartment Registration";
		Map<String, String> map1 = excelUtils.getData(sheetName, expModuleName1, expTestCaseName1);
		System.out.println(map1);
		String expRooms="5bhk";		
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");

		//owner registration
		homePageLinks.registerClick();
		ownerReg.RegisterAction(map);
		Assert.assertEquals(ownerReg.ownerRegMsgVerify(), "Registration successfull. Now you can login");

		//owner login
		homePageLinks.loginClick();	
		ownerLoginPage.ownerloginAction(map.get("username"), map.get("password"));
		
		ownerDashboardLink.registerClick();
		registerPage.apartmentRegistrationClick();
		homeReg.setDataIntoTextField(map1);
		Assert.assertEquals(adminDashboardLinks.successMessage(), "Registration successfull. Thank you");
		
		//owner update
		ownerDashboardLink.detailsClick();
		ownerDashboardLink.editClick();
		
		driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='rooms']")).clear();
		driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='rooms']")).sendKeys(expRooms);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();

		//admin login 
		driver.findElement(By.xpath("//a[.='Login']")).click();
		adminLogin.loginAction(username, password);
		String adminPage = driver.getCurrentUrl();
		if(adminPage.equals("http://rmgtestingserver/domain/House_Rental_Application/auth/dashboard.php"))
		{                    
			System.out.println("admin page is displayed");
		}
		driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
		String roomsPage= driver.getCurrentUrl(); 
		if(roomsPage.equals("http://rmgtestingserver/domain/House_Rental_Application/app/list.php")) 
		{
			System.out.println("registered rooms page is displayed");
		} 

		String actualRoom = driver.findElement(By.xpath("(//h4[.='Room Details']/..//p[6])[last()]")).getText().replaceAll("Available Rooms: ","");
		
		//verify
		Assert.assertEquals(actualRoom, expRooms, "TC is Pass");
		driver.findElement(By.xpath("//a[.='Logout']")).click();

	}
}
