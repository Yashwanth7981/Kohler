package Kohler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Titlecase {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver2/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sit.sanchivillage.com/");
		String loginTitle = driver.getTitle();
		String expextedTitle = "SanchiVillage - Connecting Communities";
		if (loginTitle.equals(expextedTitle)) {
			System.out.println("Login Test Pass");
		} else {
			System.out.println("Login Test Failed ");
		}
		driver.findElement(By.xpath("//a[@class='header_account_link user_link']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("testinc1998@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.id("pass")).sendKeys("Testing@1998" + Keys.ENTER);
//		Thread.sleep(3000);
//		WebElement Test = driver.findElement(By.xpath("//i[@class=' fa fa-user']"));
//		Actions ac = new Actions(driver);
//		ac.moveToElement(Test);

		String actualUrl = "https://sit.sanchivillage.com/";
		String expectedUrl = driver.getCurrentUrl();
		if (actualUrl.equals(expectedUrl)) {
			System.out.println("Login Test Passed and logged as Incubators");
		} else {
			System.out.println("Login Tests Failed ");
		}
		Thread.sleep(3000);
		driver.quit();

	}

}
