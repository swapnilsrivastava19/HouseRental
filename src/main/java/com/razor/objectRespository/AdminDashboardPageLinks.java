package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPageLinks {
	@FindBy(xpath = "//a[.='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath = "//a[.='Register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[.='Details/Update']")
	private WebElement detailsLink;

	@FindBy(xpath = "//a[.='Send SMS']")
	private WebElement sendSMSLink;

	@FindBy(xpath = "//a[.='Complaint List']")
	private WebElement complaintLink;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//b[text()='Rooms for Rent: ']")
	private WebElement roomsListLink;

	@FindBy(xpath = "//b[text()='Registered Users: ']") 
	private WebElement registeredUserLink;
	
	@FindBy(xpath = "//h2[.='Register Room']/preceding-sibling::div[1]")
	private WebElement registrationSuccessMessage;

	@FindBy(xpath = "//a[.='Mahantesh Kumbar (Admin)']")
	private WebElement adminPageVerification;


	public AdminDashboardPageLinks(WebDriver driver) {
		PageFactory.initElements(driver	, this);
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

	public void complaintClick() {
		complaintLink.click();
	}

	public void roomsListClick() {
		roomsListLink.click();	
	}
	public void  registeredUserClick() {
		registeredUserLink.click();
	}

	public String successMessage() {
		return registrationSuccessMessage.getText();

	}
	public String adminPageVerififcation() {

		return adminPageVerification.getText();
	}
	public void logoutClick() {
		logoutLink.click();	
	}

}
