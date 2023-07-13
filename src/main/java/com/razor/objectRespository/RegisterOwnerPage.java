package com.razor.objectRespository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Vishwanath-Naik
 *
 */
public class RegisterOwnerPage {
	@FindBy(xpath = "//input[@id='fullname']")
	private WebElement FNTextField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement UNTextField;
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement MobileTextField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailTextField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement PWDTextField;
	@FindBy(xpath = "//input[@id='c_password']")
	private WebElement ConfirmPWDTextField;
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement RegisterBtn;
	@FindBy(xpath = "//div[.='Registration successfull. Now you can login']")
	private WebElement ownerRegSuccessMsg;
	
	public RegisterOwnerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterAction(Map<String, String> map) {
		FNTextField.sendKeys(map.get("fullname"));
		UNTextField.sendKeys(map.get("username"));
		MobileTextField.sendKeys(map.get("mobile"));
		EmailTextField.sendKeys(map.get("email"));
		PWDTextField.sendKeys(map.get("password"));
		ConfirmPWDTextField.sendKeys(map.get("c_password"));
		RegisterBtn.click();
	}
	public String ownerRegMsgVerify() {
		return ownerRegSuccessMsg.getText();
	}
	
}
