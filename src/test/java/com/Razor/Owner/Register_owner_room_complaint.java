package com.Razor.Owner;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.razor.BaseAnnotation.Report;
import com.razor.EnumUtility.ExcelSheet;
import com.razor.genericUtility.BaseclassUtility;

public class Register_owner_room_complaint extends BaseclassUtility{
	
	@Report(author = "Vishwanath")
	@Test
	public void testScript4() throws IOException {
		
		//test data
		String sheetName= ExcelSheet.SHEET1.getSheetName();
		String expModuleName="OwnerTest";
		String expTestCaseName="RegisterNewOwner";
		Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
		System.out.println(map);
		String expTestCaseName1="IndividualHomeRegistration";
		Map<String, String> map1 = excelUtils.getData(sheetName, expModuleName, expTestCaseName1);
		System.out.println(map1);
		String expComplaint=map.get("cmp"); //+" "+javaUtility.getRandomNumber(100);
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");

		//owner registration
		homePageLinks.registerClick();
		ownerReg.RegisterAction(map);		
		Assert.assertEquals(ownerReg.ownerRegMsgVerify(), "Registration successfull. Now you can login");
		
		//owner login
		homePageLinks.loginClick();	
		ownerLoginPage.ownerloginAction(map.get("username"), map.get("password"));
	
		//owner register room
		ownerDashboardLink.registerClick();
		homeReg.setDataIntoTextField(map1);
		Assert.assertEquals(adminDashboardLinks.successMessage(), "Registration successfull. Thank you"); 
		
		//owner complaint
		ownerDashboardLink.detailsClick();
		ownerDashboardLink.complaintClick();
		Assert.assertEquals(ownerDashboardLink.compPageVerify(), "Complaints"); 
		compPage.complainAction(map.get("fullname"), expComplaint);
		Assert.assertEquals(compPage.compSent(), "Sent Successfully");
		ownerDashboardLink.logoutClick();
		
		//admin login
		homePageLinks.loginClick();
		adminLogin.loginAction(username, password);
		adminDashboardLinks.complaintClick();
		apartmentList.apartmentPageVerification();

		//verify complaint message
		Assert.assertEquals(compPage.compVerify(), expComplaint);
		adminDashboardLinks.logoutClick();
	}
}
