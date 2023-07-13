package com.razor.genericUtility.WebAction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * this class is used to handle pop ups and swirch window
 * @author Vishwanath-Naik
 *
 */
public class PopUpUtility {
	/**
	 * this method is used to accept pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to close the pop up
	 * @param driver
	 */
	public void closeAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to set data in pop up page
	 * @param driver
	 * @param data
	 * @return
	 */
	public void setDataToAlert(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 *  this method is used to get text from pop up page
	 * @param driver
	 * @param data
	 * @return
	 */
	public String getDataToAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * this method is used to switch window
	 * @param driver
	 * @param strategy
	 * @param verificationValue
	 */
	public void switchWindow(WebDriver driver, String strategy, String verificationValue) {
		Set<String> windows = driver.getWindowHandles();
		for(String id: windows)
		{
			driver.switchTo().window(id);
			{
				if(strategy.equalsIgnoreCase("exact_url")) {
					if(driver.getCurrentUrl().contains(verificationValue)) {
						break;
					}
				}
				else if(strategy.equalsIgnoreCase("partial_url")) {
					if(driver.getCurrentUrl().contains(verificationValue)) {
						break;
					}
				}
				else if(strategy.equalsIgnoreCase("exact_title")) {
					if(driver.getCurrentUrl().contains(verificationValue)) {
						break;
					}
				}
				else if(strategy.equalsIgnoreCase("partial_title")) {
					if(driver.getCurrentUrl().contains(verificationValue)) {
						break;
					}
				}
			}
		}
	}
}
