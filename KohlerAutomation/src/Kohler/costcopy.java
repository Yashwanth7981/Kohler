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

public class costcopy {

	public static void main(String[] args) throws Throwable {
		for (int i = 1; i <= 5; i++) {
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
			driver.get("http://kohler.co.in/");
			driver.manage().window().maximize();
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> b = driver.findElements(By.xpath("//li[@class='active']"));
			List<WebElement> b1 = driver
					.findElements(By.xpath("//*[contains(text(),'Please try a different search')]"));

			if (b1.size() > 0) {
				FileOutputStream fos0 = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue("Product Not Found");
				wb.write(fos0);
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

				driver.findElement(By.xpath("//button[@data-hasqtip='swatch00']")).click();
				String SKU1 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']"))
						.getText();
//				String SKU10 = "K-" + SKU1;
				if (SKU1.equals(excelValue)) {
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.quit();
				} else {
					continue;
				}

				String SKU2 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']"))
						.getText();
//				String SKU20 = "K-" + SKU2;

				if (SKU2.equals(excelValue)) {
					driver.findElement(By.xpath("//button[@data-hasqtip='swatch01']")).click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos1);
					driver.quit();
				} else {
					continue;
				}

				String SKU3 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']"))
						.getText();
//				String SKU30 = "K-" + SKU3;
				if (SKU3.equals(excelValue)) {
					driver.findElement(By.xpath("//button[@data-hasqtip='swatch02']")).click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos2 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos2);
					driver.quit();
				} else {
					continue;
				}

				String SKU4 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']"))
						.getText();
//				String SKU40 = "K-" + SKU4;
				if (SKU4.equals(excelValue)) {
					driver.findElement(By.xpath("//button[@data-hasqtip='swatch03']")).click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos3 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos3);
					driver.quit();
				} else {
					continue;
				}

				String SKU5 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']"))
						.getText();
//				String SKU50 = "K-" + SKU5;
				if (SKU5.equals(excelValue)) {
					driver.findElement(By.xpath("//button[@data-hasqtip='swatch04']")).click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos4 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos4);
					driver.quit();
				} else {
					continue;
				}
			} else {
				String a1 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']//ul//span[@class='value']"))
						.getText();
				FileOutputStream fos5 = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue(a1);
				wb.write(fos5);
				driver.quit();
			}
		}
	}
}
