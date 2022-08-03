package Kohler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yslinks2 {

	public static void main(String[] args) throws Throwable, IOException {
		for (int i = 1; i <= 94; i++) {
			FileInputStream fis = new FileInputStream("./Data/YsLinks.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(i);
			Cell c = r.getCell(0);
			String excelValue = c.getStringCellValue();

			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.get(excelValue);
			System.out.println(excelValue);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String t1 = "25 Years";
			String t2 = "25-year";
			String t3 = "25";
			List<WebElement> l1 = driver.findElements(By.xpath("//*[contains(text(),'25 Years')]"));
			List<WebElement> l2 = driver.findElements(By.xpath("//*[contains(text(),'25-year')]"));
			List<WebElement> l3 = driver.findElements(By.xpath("//*[contains(text(),'25')]"));

			if (l1.size() > 0) {
				System.out.println("Text: " + t1 + " is present. ");
			} else {
				System.out.println("");
			}
			if (l2.size() > 0) {
				System.out.println("Text: " + t2 + " is present. ");
			} else {
				System.out.println("");
			}
			if (l3.size() > 0) {
				System.out.println("Text: " + t3 + " is present. ");
			} else {
				System.out.println("");
			}
			driver.quit();

		}

	}
}
