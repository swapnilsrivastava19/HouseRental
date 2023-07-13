package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterLinkPage {
	
	@FindBy(xpath = "//a[.='Apartment Registration']")
	private WebElement apartmentRegistrationLink;
	
	@FindBy(xpath = "//a[.='Individual Home Registration']")
	private WebElement individualHomeRegistrationLink;
	
	public RegisterLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void  apartmentRegistrationClick() {
		apartmentRegistrationLink.click();
	}
	public void individualHomeRegistrationLink() {
		individualHomeRegistrationLink.click();
	}
}
