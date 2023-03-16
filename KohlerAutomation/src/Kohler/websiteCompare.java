package Kohler;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class websiteCompare {
	
	public static void main(String[] args) throws Throwable { 
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	
		WebDriver driver1 = new ChromeDriver();
		WebDriver driver2 = new ChromeDriver();

		// Navigate to starting pages of both websites
		driver1.navigate().to("https://h2h.multi.uat.youngsoft.in/");
		driver2.navigate().to("https://h2hsolutions.com/");

		// Verify that both websites are on expected starting pages
		if (!driver1.getCurrentUrl().equals("https://website1.com/starting-page") ||
		    !driver2.getCurrentUrl().equals("https://website2.com/starting-page")) {
		    System.out.println("Error: One or both websites are not on the expected starting page.");
		}

		// Get all links on the page and store in list
		List<WebElement> links = driver1.findElements(By.tagName("a"));

		// Loop through links and navigate to each page, comparing URLs
		for (WebElement link : links) {
		    String href = link.getAttribute("href");
		    driver1.navigate().to(href);
		    driver2.navigate().to(href);
		    if (!driver1.getCurrentUrl().equals(driver2.getCurrentUrl())) {
		        System.out.println("Error: URLs do not match for page " + href);
		    }
		}

		// Close both drivers
		driver1.quit();
		driver2.quit();

}
}
