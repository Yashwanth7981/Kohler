package Kohler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class productCheck {

	
		public static void main(String[] args) throws Throwable { 
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://kohler.co.in");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys("15399T-B-BV" + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys("15399T-B-BV" + Keys.ENTER);
		for (int i = 640; i <= 720; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet2");
			Row r = sh.getRow(i);
			Cell c = r.getCell(1);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.out.println(excelValue);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		}
}