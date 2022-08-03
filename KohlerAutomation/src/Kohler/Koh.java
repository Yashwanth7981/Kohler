package Kohler;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Koh{

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/Kohler March.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("New Products");
		Row r = sh.getRow(1);
		Cell SapCode = r.getCell(4);
		System.out.println(SapCode);
		DataFormatter formatter = new DataFormatter();
		String CellVal = formatter.formatCellValue(SapCode);
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kohler.co.in");
		driver.manage().window().maximize();
		String SapCodeValue = SapCode.getStringCellValue();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span[2]/input"))
				.sendKeys(SapCodeValue + Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		

	}

}
