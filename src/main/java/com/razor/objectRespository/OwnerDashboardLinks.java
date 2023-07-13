package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerDashboardLinks {
	@FindBy(xpath = "//a[.='Home']")
	private WebElement homeLink;

	@FindBy(xpath = "//a[.='Register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[.='Details/Update']")
	private WebElement detailsLink;
	
	@FindBy(xpath = "//b")
	private WebElement roomsListLink;
	
	@FindBy(xpath = "//h1")
	private WebElement ownerPageVerification;
	
	@FindBy(xpath = "//a[.='Edit']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//a[.='Complaint']")
	private WebElement complaintBtn;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//h2[.='Complaints']")
	private WebElement compPageVerify;
	
	public OwnerDashboardLinks(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void homeClick() {
		homeLink.click();
	}
	public void registerClick() {
		registerLink.click();
	}
	public void detailsClick() {
		detailsLink.click();
	}

	public void roomsListClick() {
		roomsListLink.click();	
	}
	public void editClick() {
		editBtn.click();	
	}
	public void complaintClick() {
		complaintBtn.click();	
	}
	public String ownerPageVerification() {
		return ownerPageVerification.getText();
	}
	public String compPageVerify() {
		return compPageVerify.getText();
	}
	
	public void logoutClick() {
		logoutLink.click();	
	}
}
