package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRoomPage {
	@FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='sale']")
	private WebElement saleTextField;
	
	@FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='accommodation']")
	private WebElement accomTextField;
	
	@FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='description']")
	private WebElement descripTextField;
	
	@FindBy(xpath = "//input[@type='other']")
	private WebElement otherTextField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	public EditRoomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void editAction(String expSale, String accom, String description, String other) {
		saleTextField.clear();
		accomTextField.clear();
		descripTextField.clear();
		saleTextField.sendKeys(expSale);
		accomTextField.sendKeys(accom);
		descripTextField.sendKeys(description);
		otherTextField.sendKeys(other);
		submitButton.click();
	}
}
