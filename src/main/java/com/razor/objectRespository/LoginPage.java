package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(xpath = "//input[@id='exampleInputEmail1']")
	private WebElement userNameTextField;
	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	private WebElement passwordTextField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//h2[.='Login']")
	private WebElement loginPageVerification;
	
	//initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void loginAction(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	public String loginPageVerify() {
		return loginPageVerification.getText();
	}
}
