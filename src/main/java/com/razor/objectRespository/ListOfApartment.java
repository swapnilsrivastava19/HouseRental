package com.razor.objectRespository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfApartment {
	
	@FindBy(xpath = "//h2[.='List of Apartment Details']")
	private WebElement apartmentPageVerification;
	
	
	@FindBy(xpath = "//h4[.='Room Details']/..//p[2]//b[.='Sale: ']/../..//p[2]")
	private List<WebElement> saleListVerification;
	
	@FindBy(xpath = "//h4[.='Owner Details']/../p[1]")
	private List<WebElement> ownerNameVerification;
	
	public ListOfApartment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String apartmentPageVerification() {
		return apartmentPageVerification.getText();
	}
	
	public String ownerNameVerification() {
		String actualName="";
		for(WebElement ele : ownerNameVerification)
		{
			actualName= ele.getText().replaceAll("Owner Name: ","");
		}
		return actualName;
	}

	public String saleListVerification(String expSale) {
		String actualSale="";
		for(WebElement ele1 : saleListVerification)
		{
			actualSale= ele1.getText().replaceAll("Sale: ","");
			if(actualSale.contains(expSale))break;
		}
		return actualSale;
	}
}
