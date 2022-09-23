package Kohler;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kohler1 {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kohler.co.in");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span[2]/input"))
				.sendKeys("15399T-B-BV", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span[2]/input"))
		.sendKeys("15399T-B-BV", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> f = driver.findElements(By.tagName("frame"));
		System.out.println("Total number " + f.size());
		
	}

}
