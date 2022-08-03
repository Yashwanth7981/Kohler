package Kohler;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Sanchi {
	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.sanchivillage.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='header_account_link user_link']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("yashwanthb1133@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.id("pass")).sendKeys("Testing@1998" + Keys.ENTER);
		Thread.sleep(5000);
		driver.get("https://uat.sanchivillage.com/explore.html");
		Thread.sleep(5000);
		driver.findElement(By.id("search")).sendKeys("yash'" + Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,100)");	
		TakesScreenshot SS = (TakesScreenshot) driver;
		File Src = SS.getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\ScreenShot Selenium\\SS.jpg");
		Files.copy(Src, Dest);
		driver.get("https://uat.sanchivillage.com/incubators/index/index/");
		Thread.sleep(3000);
		driver.findElement(By.id("incubators")).sendKeys("yash'" + Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");
		TakesScreenshot SS1 = (TakesScreenshot) driver;
		File Src1 = SS1.getScreenshotAs(OutputType.FILE);
		File Dest1 = new File("C:\\ScreenShot Selenium\\SS2.jpg");
		Files.copy(Src1, Dest1);
		driver.get("https://uat.sanchivillage.com/marketplace/seller/sellerlist/");
		Thread.sleep(3000);
		driver.findElement(By.id("sellersearch")).sendKeys("yash'" + Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		TakesScreenshot SS2 = (TakesScreenshot) driver;
		File Src11 = SS2.getScreenshotAs(OutputType.FILE);
		File Dest11 = new File("C:\\ScreenShot Selenium\\SS3.jpg");
		Files.copy(Src11, Dest11);
		driver.get("https://uat.sanchivillage.com/employees/index/index/");
		Thread.sleep(3000);
		driver.findElement(By.id("employees")).sendKeys("yash'" + Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		TakesScreenshot SS3 = (TakesScreenshot) driver;
		File Src111 = SS3.getScreenshotAs(OutputType.FILE);
		File Dest111 = new File("C:\\ScreenShot Selenium\\SS4.jpg");    
		Files.copy(Src111, Dest111);
		driver.get("https://uat.sanchivillage.com/investors/index/index/");
		Thread.sleep(3000);
		driver.findElement(By.id("sellersearch")).sendKeys("yash'" + Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		TakesScreenshot SS1111 = (TakesScreenshot) driver;
		File Src1111 = SS1111.getScreenshotAs(OutputType.FILE);
		File Dest1111 = new File("C:\\ScreenShot Selenium\\SS5.jpg");
		Files.copy(Src1111, Dest1111);
		System.out.println("Done with screen shots");
		driver.quit();

	}
}
