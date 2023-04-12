package Kohler;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class contentOfProducts {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://kohler.co.in");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("98930X-1-0" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("11341IN-1-0" + Keys.ENTER);
		String ComName = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
		System.out.println(ComName);
		String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']")).getText();
		System.out.println(ShortDes);
		String Price = driver.findElement(By.xpath("//span[@class='value']")).getText();
		System.out.println(Price);
		String Imgsrc = driver.findElement(By.xpath("//img[@class='koh-product-iso-image koh-product-img']"))
				.getAttribute("src");
		System.out.println(Imgsrc);
		List<WebElement> b = driver.findElements(By.xpath("//div[@class='koh-product-features-description-files']"));
		if (b.size() > 0) {
			String longDes = driver.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
					.getText();
			System.out.println(longDes);
		} else {
			System.out.println("No Long Description Found");
		}

		List<WebElement> b1 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
		if (b1.size() > 0) {
			String Collection = driver.findElement(By.xpath("//span[@class='koh-product-col-description']")).getText();
			System.out.println(Collection);
		} else {
			System.out.println("No Collection Found");
		}
		List<WebElement> b2 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
		if(b2.size()>0) {
			String Installation =  driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[4]")).getText();
			System.out.println(Installation);
		}
		else {
			System.out.println("No Installation Found");
		}
	}
}
