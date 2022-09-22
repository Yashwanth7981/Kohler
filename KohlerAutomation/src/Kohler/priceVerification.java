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
import org.testng.annotations.Test;


public class priceVerification{
	@Test(priority=1,enabled=true)
//	Price Validation
public void pv() throws Throwable {
		for (int i = 1; i <= 6; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(i);
			Cell c = r.getCell(1);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			System.out.println(excelValue);
			driver.get("https://kohler.co.in/");
			driver.manage().window().maximize();
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);

			List<WebElement> b = driver.findElements(By.xpath("//li[@class='active']"));
			List<WebElement> b1 = driver
					.findElements(By.xpath("//*[contains(text(),'Please try a different search')]"));
			List<WebElement> b2 = driver
					.findElements(By.xpath("//*[contains(text(),'This product has been discontinued.')]"));
			if (b1.size() > 0) {
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue("Product Not Found");
				wb.write(fos);
				driver.quit();
			}
			else if(b2.size()>0) {
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue("Product Discontinued");
				wb.write(fos);
				driver.quit();

			} 
			else if (b.size() > 0) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.xpath("//div[@class='koh-product-image']")).click();
				Set<String> st = driver.getWindowHandles();
				Iterator<String> it = st.iterator();
				String parent = it.next();
				String child = it.next();
				driver.switchTo().window(parent);
				driver.switchTo().window(child);
//			-------------------------------------------------------------------
				if (excelValue.contains("BL")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BL?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
					
				} else if (excelValue.contains("BV")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BV?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
					
				} else if (excelValue.contains("RGD")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_RGD?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
					
				} else if (excelValue.contains("AF")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_AF?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				
				} else if (excelValue.contains("CP")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_CP?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				
				} else if (excelValue.contains("NA")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_NA?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				} else if (excelValue.contains("SHP")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_SHP?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				} else if (excelValue.contains("BGL")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BGL?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				} else if (excelValue.contains("HG1")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HG1?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				} else if (excelValue.contains("HP1")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HP1?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				} 
				else if (excelValue.contains("-0")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_0?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				}
				else if (excelValue.contains("-7")) {
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_7?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				}
				else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("No Colour Match Found");
					wb.write(fos);
					driver.quit();
				}

			} else {
				String a1 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']//ul//span[@class='value']"))
						.getText();
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue(a1);
				wb.write(fos);
				driver.quit();
			}

		}
	}
}
