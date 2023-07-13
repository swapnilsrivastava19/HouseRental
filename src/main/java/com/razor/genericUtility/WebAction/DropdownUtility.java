package com.razor.genericUtility.WebAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * this class is used to handle dropdown
 * @author Vishwanath-Naik
 *
 */
public class DropdownUtility {
     /**
      * this method is used to select options from single select dropdown based on value
      * @param element
      * @param value
      */
	public void handleDropdown(WebElement element, String value) {
		Select indDD = new Select(element);
		indDD.selectByValue(value);
	}
	/**
	 * this method is used to select options from single select dropdown based on visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropdown(String visibleText, WebElement element) {
		Select indDD = new Select(element);
		indDD.selectByVisibleText(visibleText);
	}
	/**
	 * this method is used to select options from single select dropdown based on index of options
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select indDD = new Select(element);
		indDD.selectByIndex(index);
	}
	
}
