package Kohler;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class productContent {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
   	    WebDriver driver = new ChromeDriver();
		driver.get("https://kohler.co.in");
		driver.manage().window().maximize();
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
		.sendKeys("74027IN-4BND-CP", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String a=driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
		System.out.println(a);
		driver.quit();
		
	}

}
