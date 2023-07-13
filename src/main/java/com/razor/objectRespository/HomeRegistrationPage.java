package com.razor.objectRespository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
import com.razor.genericUtility.WebAction.DropdownUtility;
import com.razor.genericUtility.WebAction.SeleniumUtility;

public class HomeRegistrationPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//h2[.='Register Room']/../form/div[6]/following-sibling::button")
	private WebElement roomRegisterBtn;
	
	@FindBy(xpath = "(//select[@id='vacant'])[1]")
	private WebElement dropDown;
	
	DropdownUtility dd = new DropdownUtility();
	
	String visibleTxt = "Occupied";
	String RegisterRoomPagePartialXpath = "//h2[.='Register Room']/..//div/input[@id='%s']";

	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public HomeRegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setDataIntoTextField(Map<String, String> RoomRegister)
	{
		dd.handleDropdown(visibleTxt, dropDown);
		for (Entry<String, String> keyValue : RoomRegister.entrySet())
		{
			convertToElement(RegisterRoomPagePartialXpath, keyValue.getKey()).sendKeys(keyValue.getValue());
		}
		roomRegisterBtn.click();
	}
}

	
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='fullname']")
//	  private WebElement FNTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='mobile']")
//	  private WebElement MobileTextField;
//	  
//	  @FindBy(xpath =
//	  "//h2[.='Register Room']/..//div/input[@id='alternat_mobile']") 
//	  private WebElement AltMobileTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='email']")
//	  private WebElement emailTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='plot_number']")
//	  private WebElement PlotTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='rooms']") 
//	  private WebElement roomsTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='country']")
//	  private WebElement countryTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='state']") 
//	  private WebElement stateTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='city']") 
//	  private WebElement cityTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='rent']") 
//	  private WebElement rentTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='sale']") 
//	  private WebElement saleTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='deposit']")
//	  private WebElement depositTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='landmark']")
//	  private WebElement landmarkTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='address']")
//	  private WebElement addressTextField;
//	  
//	  @FindBy(xpath = "//h2[.='Register Room']/..//div/input[@id='image']") 
//	  private WebElement imageTextField;
//	 
//	
	 
//	 
//
//	
//	  public void RoomRegisterAction(Map<String, String> map, String expFullName)
//	  {
//	  FNTextField.sendKeys(expFullName);
//	  MobileTextField.sendKeys(map.get("mobile"));
//	  AltMobileTextField.sendKeys(map.get("alternat_mobile"));
//	  emailTextField.sendKeys(map.get("email"));
//	  PlotTextField.sendKeys(map.get("plot_number"));
//	  roomsTextField.sendKeys(map.get("rooms"));
//	  countryTextField.sendKeys(map.get("country"));
//	  stateTextField.sendKeys(map.get("state"));
//	  cityTextField.sendKeys(map.get("city"));
//	  rentTextField.sendKeys(map.get("rent"));
//	  saleTextField.sendKeys(map.get("sale"));
//	  depositTextField.sendKeys(map.get("deposit"));
//	  landmarkTextField.sendKeys(map.get("facilities"));
//	  addressTextField.sendKeys(map.get("landmark"));
//	  imageTextField.sendKeys(map.get("image");
//	  roomRegisterBtn.click(); 
//	  }
	 

