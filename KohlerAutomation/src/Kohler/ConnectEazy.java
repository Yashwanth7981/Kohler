package Kohler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectEazy {
	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://connecteazyritwik.lightning.force.com/lightning/n/Nrich__TimeSheet_Dashboard");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("yashwanth.b@youngsoft.in");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Yash@ritwik123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='small mt8 ib']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("sem1")).click();
		driver.findElement(By.id("save")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//input[@class='button primary wide mt8 mb16']")).click();
//		Thread.sleep(5000);
//		Alert alert = driver.switchTo().alert();
//		String alertMessage = driver.switchTo().alert().getText();
//		System.out.println(alertMessage);
//		Thread.sleep(15000);
//		driver.findElement(By.xpath("//input[@id='save']")).click();
//		Thread.sleep(10000); 
//		driver.findElement(By.xpath("div[@id='AddTaskDiv']//button")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("div[@class='slds-select_container']//select")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("div[@class='slds-form-element__control slds-grow']//input[@id='input-64']")).click();
//		Thread.sleep(5000);

//  	driver.navigate().refresh();
//		Alert alert = driver.switchTo().alert();
//		driver.switchTo().alert();
//		alert.dismiss();
//		driver.findElement(By.xpath("//div[@id='AddTaskDiv']//button[2]")).click();

//		driver.findElement(By.id("AddTaskDiv")

	}
}
