package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jse1 {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.facebook.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location=arguments[0]","https://www.facebook.com");
		WebElement ele = driver.findElement(By.xpath("//a[.='Help']"));
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement ele2 = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement ele3 = driver.findElement(By.xpath("//button[@name='login']"));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView()",ele);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
//		js.executeScript("arguments[0].setAttribute('style','border:6px solid red;');",ele2);
		js.executeScript("arguments[0].style.border='3px solid red'", ele2);
		js.executeScript("arguments[0].style.backgroundColor = 'yellow'", ele1);
		js.executeScript("arguments[0].value=arguments[1]",ele1, "jdjajak");
		js.executeScript("arguments[0].value=arguments[1]",ele2,"jfklajfj");
//		js.executeScript("arguments[0].click()",ele3);
		
	}
}
