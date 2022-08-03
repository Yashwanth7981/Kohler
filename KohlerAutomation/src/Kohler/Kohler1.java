package Kohler;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kohler1 {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./Data/Koh.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Available products on website");
		Row r = sh.getRow(1);
		Cell SapCode = r.getCell(0);
		Cell Price = r.getCell(6);
		DataFormatter formatter = new DataFormatter();
		String CellVal = formatter.formatCellValue(SapCode);

		System.out.println(SapCode);
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kohler.co.in");
		Thread.sleep(2000);
		String SapCodeValue = SapCode.getStringCellValue();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span[2]/input"))
				.sendKeys(SapCodeValue, Keys.ENTER);

		WebElement a = driver.findElement(By.xpath("//span[@class='value']"));

		driver.quit();

	}

}
