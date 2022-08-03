package Kohler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductFound {
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://kohler.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("29937IN-CP", Keys.ENTER);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		List<WebElement> a = driver.findElements(By.xpath("//*[contains(text(),'Please try a different search')]"));
		if (a.size() > 0) {
			System.out.println("Product not Found");
		} else {
			System.out.println("Product Found");
		

	}
		driver.quit();
}
}
