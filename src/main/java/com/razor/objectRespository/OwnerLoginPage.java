package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerLoginPage {
 
	@FindBy(xpath = "//input[@id='exampleInputEmail1']")
	private WebElement ownerNameTextField;
	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	private WebElement opasswordTextField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//h2[.='Login']")
	private WebElement loginPageVerification;
	
	//initialization
	public OwnerLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void ownerloginAction(String username, String password) {
		ownerNameTextField.sendKeys(username);
		opasswordTextField.sendKeys(password);
		loginButton.click();
	}
	public String loginPageVerification() {
		return loginPageVerification.getText();
	}
}
