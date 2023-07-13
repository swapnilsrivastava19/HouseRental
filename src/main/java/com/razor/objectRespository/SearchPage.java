package com.razor.objectRespository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	@FindBy(xpath = "//input[@id='keywords']")
	private WebElement keyTextField;
	@FindBy(xpath = "//input[@id='location']")
	private WebElement locationTextField;
	@FindBy(xpath = "//button[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//h4[.='Room Details']/..//div[1]/p")
	private List<WebElement> apartmentNameVerification;
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchAction(String keyword, String location) {
		keyTextField.sendKeys(keyword);
		locationTextField.sendKeys(location);
	}
	public String apartmentNameVerification() {
		String actualAptName="";
		for(WebElement ele: apartmentNameVerification) {
			actualAptName = ele.getText().replaceAll("Apartment Name: ","");
		}
		return actualAptName;
	}
	public void searchClick() {
		searchBtn.click();
	}
	
}
