import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://kohler.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("15399T-B-BV" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("153hu6" + Keys.ENTER);
		List<WebElement> b1 = driver
				.findElements(By.xpath("//div[@class='koh-hero-container']/p"));
		if(b1.size()>0) {
			System.out.println("Product Not Found");
		}
		else {
			System.out.println("Found");
		}
		
		

	}

}
