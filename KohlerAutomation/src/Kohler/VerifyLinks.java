package Kohler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class VerifyLinks {
	public static void main(String[] args) throws IOException, Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://youngsoft.in");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("No of links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			URL link = new URL(url);
			HttpURLConnection HUC = (HttpURLConnection) link.openConnection();
			Thread.sleep(2000);
			HUC.connect();
			int respCode = HUC.getResponseCode();
			if (respCode >= 400) {
				System.out.println(url + " - " + "is a Broken Link");

			} 
			else if (url == null || url.isEmpty()) {
				System.out.println("URL not configured with anchor tag");
				continue;
			}else {
				System.out.println(url + " - " + "is a Valid Link");
			}
		}
	}
}