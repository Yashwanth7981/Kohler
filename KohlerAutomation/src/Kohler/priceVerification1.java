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
//import org.testng.annotations.Test;

public class priceVerification1 {

//	@Test
//	public void pv() throws Throwable {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://plumbingindia.kohler.test.us.onehippo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("15399T-B-BV" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		for (int i = 7; i <= 1334; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(i);
			Cell c = r.getCell(1);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.out.println(excelValue);
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> b = driver.findElements(By.xpath("//li[@class='active']"));
//			List<WebElement> b1 = driver
//					.findElements(By.xpath("//div[@class='koh-hero-container']/p"));
			List<WebElement> b1 = driver
					.findElements(By.xpath("//*[contains(text(),'Please try a different search')]"));
			List<WebElement> b2 = driver
					.findElements(By.xpath("//*[contains(text(),'This product has been discontinued.')]"));
			if (b1.size() > 0) {
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue("Product Not Found");
				wb.write(fos);
//				driver.quit();
			} else if (b2.size() > 0) {
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue("Product Discontinued");
				wb.write(fos);
//				driver.quit();

			} else if (b.size() > 0) {
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
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_BL?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);

				} else if (excelValue.contains("BV")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_BV?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("DGS")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_DGS?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("RGD")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_RGD?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("AF")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_AF?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("CP")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_CP?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("NA")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_NA?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("SHP")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_SHP?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BGL")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_BGL?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BLL")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_BLL?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BN")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_BN?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("HG1")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_HG1?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("HP1")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_HP1?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("VS")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_VS?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);

				} else if (excelValue.contains("-0")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_0?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("-7")) {
					driver.findElement(
							By.xpath("//img[@src='//kohler.scene7.com/is/image/PAWEB/swatch_7?$SwatchSS$']"))
							.click();
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("No Colour Match Found");
					wb.write(fos);
//					driver.quit();
				}

			} else {
				String a1 = driver
						.findElement(By.xpath("//div[@class='koh-product-skus-colors']//ul//span[@class='value']"))
						.getText();
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue(a1);
				wb.write(fos);
//				driver.quit();
			}

		}

	}

}
