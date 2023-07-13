package com.razor.objectRespository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentRegistrationPage{
	
	@FindBy(xpath = "//h2[.='Apartment Room']/../form/div[6]/following-sibling::button")
	private WebElement apartmentRegisterBtn;
	
	@FindBy(xpath = "//a[.='Add More(Plat Number/Description)']")
	private WebElement addMoreBtn;
	
    private WebDriver driver;
    
	String RegisterApartmentPartialXpath = "//h2[.='Apartment Room']/..//div/input[@id='%s']";

	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public ApartmentRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setDataIntoTextField(Map<String, String> RoomRegister)
	{
		addMoreBtn.click();
		for (Entry<String, String> keyValue : RoomRegister.entrySet()) 
		{
			convertToElement(RegisterApartmentPartialXpath, keyValue.getKey()).sendKeys(keyValue.getValue());
		}
		apartmentRegisterBtn.click();
	}
}






















//
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='apartment_name']")
//	private WebElement aptNameTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='mobile']")
//	private WebElement mobileTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='alternat_mobile']")
//	private WebElement altMobileTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='email']")
//	private WebElement emailTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='plot_number']")
//	private WebElement plotNumTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='country']")
//	private WebElement countryTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='state']")
//	private WebElement stateTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='city']")
//	private WebElement cityTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='landmark']")
//	private WebElement landmarkTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='address']")
//	private WebElement addressTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='image']")
//	private WebElement imageTextField;
//	@FindBy(xpath = "//a[.='Add More(Plat Number/Description)']")
//	private WebElement addMoreBtn;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='fullname']")
//	private WebElement fullNameTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='ap_number_of_plats']")
//	private WebElement flatNumTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='rooms']")
//	private WebElement roomsTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='area']")
//	private WebElement areaTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='rent']")
//	private WebElement rentTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='deposit']")
//	private WebElement depositTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='accommodation']")
//	private WebElement accomTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/..//div/input[@id='description']")
//	private WebElement descriptTextField;
//	@FindBy(xpath = "//h2[.='Apartment Room']/../form/div[6]/following-sibling::button")
//	private WebElement aptRegisterBtn;
//	
//	public ApartmentRegistrationPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//	
//	public void apartmentRegisterAction(Map<String, String> map) 
//	{
//		aptNameTextField.sendKeys(map.get("apartment_name"));
//		mobileTextField.sendKeys(map.get("mobile"));
//		altMobileTextField.sendKeys(map.get("alternat_mobile"));
//		emailTextField.sendKeys(map.get("email"));
//		plotNumTextField.sendKeys(map.get("plot_number"));
//		countryTextField.sendKeys(map.get("country"));
//		stateTextField.sendKeys(map.get("state"));
//		cityTextField.sendKeys(map.get("city"));
//		landmarkTextField.sendKeys(map.get("landmark"));
//		addressTextField.sendKeys(map.get("address"));
//		imageTextField.sendKeys(map.get("image"));
//		addMoreBtn.click();
//		fullNameTextField.sendKeys(map.get("fullname"));
//		flatNumTextField.sendKeys(map.get("ap_number_of_plats"));
//		roomsTextField.sendKeys(map.get("rooms"));
//		areaTextField.sendKeys(map.get("area"));
//		rentTextField.sendKeys(map.get("rent"));
//		depositTextField.sendKeys(map.get("deposit"));
//		accomTextField.sendKeys(map.get("accomodation"));
//		descriptTextField.sendKeys(map.get("description"));
//		aptRegisterBtn.click();
//		
//	}
//	
//}
