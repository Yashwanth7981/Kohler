package Kohler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://youtube.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='search-input']//input")).click();
		driver.findElement(By.xpath("//div[@id='search-input']//input")).sendKeys("Selenium"+Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,100)");	
     	Thread.sleep(3000);
     	driver.findElement(By.xpath("//div[@class='style-scope ytd-video-renderer']//ytd-thumbnail")).click();
//     	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    	driver.quit();
	}

}
