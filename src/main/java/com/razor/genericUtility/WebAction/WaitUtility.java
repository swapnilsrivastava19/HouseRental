package com.razor.genericUtility.WebAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains all wait method like implicit, explicit and custom waits
 * @author Vishwanath-Naik
 *
 */
public class WaitUtility {
	private WebDriverWait wait;
	private WebDriver driver;
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public void WaitUtility(WebDriver driver) {
		wait= new WebDriverWait(driver, 10);
	}
	
	/**
	 * 
	 * @param milisecond
	 */
	public void pause(long milisecond)
	{
		try {
			Thread.sleep(milisecond);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public void WaitForElementLoad(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param xpath
	 */
	public void waitUntilVisible(String xpath) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * 
	 * @param xpath
	 */
	public void waitUntilClickable(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * 
	 * @param xpath
	 */
	public void waitUntilInVisible(String xpath) {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * 
	 * @param xpath
	 * @param text
	 */
	public void waituntilInvisibleOfText(String xpath, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), text));
	}
	/**
	 * this method is used to perform custom wait
	 * @param pollingTime
	 * @param duration
	 * @param element
	 * @throws Exception
	 */
	public void waitTillClick(long pollingTime, int duration, WebElement element) throws Exception {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(pollingTime);
				count++;
			}
		}
	}
}
