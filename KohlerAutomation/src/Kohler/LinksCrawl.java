package Kohler;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCrawl {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String homePage = "https://youngsoft.in/";
		driver.get(homePage);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("No of links are " + allLinks.size());
		for (WebElement link : allLinks) {
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
	}
}
