package com.razor.objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLinks {
     @FindBy(xpath = "//a[.='Login']")
     private WebElement loginLink;
     
     @FindBy(xpath = "//a[.='Register']")
     private WebElement registerLink;
     
     @FindBy(xpath = "//a[.='Search']")
     private WebElement searchLink;
     
     @FindBy(xpath = "//div[.='Welcome To Room Rental Registration!']")
     private WebElement homePageVerification;
     
     public HomePageLinks(WebDriver driver) {
 		PageFactory.initElements(driver, this);
 	}
     
     public void loginClick() {
    	 loginLink.click();
     }
     public void registerClick() {
    	 registerLink.click();
     }
     public void searchClick() {
    	 searchLink.click();
     }
     public String homePageVerification()
     {
    	 return homePageVerification.getText();
     }
}
