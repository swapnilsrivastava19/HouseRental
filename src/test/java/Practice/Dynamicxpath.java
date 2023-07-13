package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Dynamicxpath {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		WebElement ele = driver.findElement(By.xpath("//nav[@class='cb-nav cb-col cb-col-100 ng-scope']//a[@class='cb-hm-mnu-itm']"));
		System.out.println(ele.getText());
	}
}
