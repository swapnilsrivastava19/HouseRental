package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplaintPage {

	@FindBy(xpath = "//input[@id='name']")
	private WebElement ownerName;
	
	@FindBy(xpath = "//input[@id='cmp']")
	private WebElement complaintMsg;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[.='Sent Successfully']")
	private WebElement compSuccesssMsg;
	
	@FindBy(xpath = "(//table[@class='table table-bordered']//tbody//tr//td)[last()-1]")
	private WebElement compVerification;
	
	// create comp page verififcation
	
	public ComplaintPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void complainAction(String expName, String comp) {
			ownerName.sendKeys(expName);
			complaintMsg.sendKeys(comp);
			submitBtn.click();	
	}
	public String compSent() {
		return compSuccesssMsg.getText();
	}
	public String compVerify() {
		return compVerification.getText();
	}
}
