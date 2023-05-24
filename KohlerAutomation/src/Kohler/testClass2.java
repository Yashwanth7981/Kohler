package Kohler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testClass2 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://moovitapp.com/index/en/public_transit-lines-NYCNJ-121-857463");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='lines-container agency-lines']/ul/li[1]")).click();
		String Route = driver.findElement(By.xpath("//ul[@class='stops-list bordered']")).getText();
		System.out.println("Now the Routes are " + Route);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='stops-list bordered']/li[1]/div/button")).click();
		String Schedule = driver.findElement(By.xpath("//div[@class='arrivals-list']")).getText();
		System.out.println("Now the Schedule is : " + Schedule);
	}

}
