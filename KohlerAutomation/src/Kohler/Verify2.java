package Kohler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify2 {

	public static void main(String[] args) throws Throwable {

		String homePage = "http://mytruadvantage.com/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(homePage);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links are " + links.size());
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
//			System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println(url + "--" + "URL is not configured with anchor tag");
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				Thread.sleep(10000);
				huc.connect();
				respCode = huc.getResponseCode();
				if (respCode >= 400) {
					System.out.println(url + "--" + " is the broken link");
				} else {
					System.out.println(url + "--" + " is the valid link");
				}
			} catch (MalformedURLException e) {    
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		driver.quit();
	}
}