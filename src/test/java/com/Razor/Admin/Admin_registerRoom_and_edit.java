package com.Razor.Admin;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.razor.EnumUtility.ExcelSheet;
import com.razor.genericUtility.BaseclassUtility;

public class Admin_registerRoom_and_edit extends BaseclassUtility{
	
		@Test
		public void testScipt5() throws InterruptedException, IOException {

	        //test data
			String sheetName= ExcelSheet.SHEET1.getSheetName();
			String expModuleName="AdminTest";
			String expTestCaseName="IndividualHomeRegistration";
			Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
			System.out.println(map);
			String expSale="869560"; //+" "+javaUtility.getRandomNumber(100);
			String expFullName= map.get("fullname");
			String Other="thunder";
			Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
			

			//admin login and register room
			homePageLinks.loginClick();
			adminLogin.loginAction(username, password);
			Assert.assertEquals(adminDashboardLinks.adminPageVerififcation(), "MAHANTESH KUMBAR (ADMIN)");
			String adminPage = driver.getCurrentUrl();
			adminDashboardLinks.registerClick();
			homeReg.setDataIntoTextField(map);
			Assert.assertEquals(adminDashboardLinks.successMessage(), "Registration successfull. Thank you"); 
			
			//admin edit owner
			driver.findElement(By.xpath("//a[.='Details/Update']")).click();
			
			List<WebElement>list = driver.findElements(By.xpath("//h4[.='Owner Details']/../p[1]"));
		    String actualFullName = "";
		    for(WebElement ele3:list)
		     { 
		    	 actualFullName =ele3.getText().replaceAll("Owner Name: ","");
		     }
		    if(actualFullName.equalsIgnoreCase(expFullName))
		    {
			driver.findElement(By.xpath("(//a[.='Edit'])[last()]")).click();
			driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).clear();
			driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).sendKeys(expSale);
			driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).clear();
			driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='description']")).clear();
			driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).sendKeys(map.get("accommodation"));
			driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='description']")).sendKeys(map.get("description"));
			driver.findElement(By.xpath("//input[@type='other']")).sendKeys(Other);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    }
			driver.findElement(By.xpath("//a[.='Home']")).click();
			driver.findElement(By.xpath("//a[.='Details/Update']")).click();
			String detailsPage= driver.getCurrentUrl();
			if(detailsPage.equals("http://rmgtestingserver/domain/House_Rental_Application/app/list.php"))
			{                    
				System.out.println("details page is displayed");
			}
			List<WebElement> list1= driver.findElements(By.xpath("//h4[.='Room Details']/..//p[2]//b[.='Sale: ']/../..//p[2]"));
			String actualSale = "";
			for(WebElement ele1:list1)
			{
				actualSale = ele1.getText().replaceAll("Sale: ","");
			}
			
		     Assert.assertEquals(actualSale, expSale , "TC is Pass");
		     driver.findElement(By.xpath("//a[.='Logout']")).click();
	}
}



