package com.razor.genericUtility.WebAction;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all browser utils
 * @author Vishwanath-Naik
 *
 */
public class SeleniumUtility {
	private WebDriver driver;
	/**
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser, @Optional String...s )
	{
		switch (browser)
		{
		case "chrome":
			if(s[0].equalsIgnoreCase("option")) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				break;
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				break;
			}

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("enter proper key ");
			break;
		}
		return driver;
	}
	/**
	 * This method is used to maximize the browser 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to pass the url of app
	 * @param url
	 */
	public void launchApplication(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to resize the browser
	 * @param width
	 * @param height
	 */
	public void resizeBrowser(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}
	/**
	 * this method is uded to fetch current url of the webpage
	 * @return
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	/**
	 * this method is used to fetch title of the webpage
	 * @return
	 */
	public String getCurrentTitle() {
		return driver.getTitle();
	}
	/**
	 * This method is used to close the entire browser
	 * @return 
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * This method is used to close single tab
	 */
	public void closeTab() {
		driver.close();
	}	
}
