package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopUp {
	@Test
	public void pop() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.google.com/search?q=redbus&rlz=1C1CHWL_"
				+ "enIN961IN961&oq=redbus+&aqs=chrome..69i57j0i20i263i433i512j0"
				+ "i433i512l2j0i512j0i433i512l2j69i60.4629j0j7&sourceid=chrome&ie=UTF-8");
		
	}
}
