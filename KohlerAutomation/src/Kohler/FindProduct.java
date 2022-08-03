package Kohler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindProduct {

	public static void main(String[] args) throws Throwable {
		for (int i = 1; i <= 100; i++) {
			FileInputStream fis = new FileInputStream("./Data/Koh39.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(i);
			Cell c = r.getCell(1);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			System.out.println(excelValue);
			driver.get("http://kohler.co.in/");
			driver.manage().window().maximize();
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']//span[2]//span//button//span")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		 	js.executeScript("window.scrollBy(0,200)");
// 		String q=driver.findElement(By.xpath("//div[@class='koh-hero-container']//p")).getText();
// 		System.out.println(q);
			List<WebElement> a = driver.findElements(By.xpath("//*[contains(text(),'0 Search Results')]"));
			String c1 = "Product Not Found";

			if (a.size() > 0) {
				FileOutputStream fos = new FileOutputStream("./Data/Koh39.xlsx");
				r.createCell(2).setCellValue(c1);
				wb.write(fos);

			} else {

			}

		}
	}
}
