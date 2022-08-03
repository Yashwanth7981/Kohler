package Kohler;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Youngsoft {
	public static void main(String[] args) throws Throwable {
//		FileInputStream fis = new FileInputStream("./Data/Koh.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("New Products");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String url = "https://youngsoft.com/products/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String t1 = "25 Years";
		String t2 = "25-year";
		String t3 = "25";
		List<WebElement> l1 = driver.findElements(By.xpath("//*[contains(text(),'25 Years')]"));
		List<WebElement> l2 = driver.findElements(By.xpath("//*[contains(text(),'25-year')]"));
		List<WebElement> l3 = driver.findElements(By.xpath("//*[contains(text(),'25')]"));

		if (l1.size() > 0) {
			System.out.println("Text: " + t1 + " is present. ");
		} else {
			System.out.println("Text: " + t1 + " is not present. ");
		}
		if (l2.size() > 0) {
			System.out.println("Text: " + t2 + " is present. ");
		} else {
			System.out.println("Text: " + t2 + " is not present. ");
		}
		if (l3.size() > 0) {
			System.out.println("Text: " + t3 + " is present. ");
		} else {
			System.out.println("Text: " + t3 + " is not present. ");}
			
			driver.quit();
		}
	}

