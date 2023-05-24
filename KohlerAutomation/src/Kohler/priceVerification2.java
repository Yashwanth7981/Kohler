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

public class priceVerification2 {


	public static void main(String[] args) throws Throwable { 
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://plumbingindia.kohler.test.us.onehippo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("15399T-B-BV" + Keys.ENTER);

		for (int i = 1990; i <= 2002; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet4");
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
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BL?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);

				} else if (excelValue.contains("BV")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BV?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
			}
				else if (excelValue.contains("PGD")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_PGD?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
			}
				else if (excelValue.contains("DGS")) {
				js.executeScript("window.scrollBy(0,100)");
				driver.findElement(
						By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_DGS?$SwatchSS$']"))
						.click();
				List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
				if(Pri.size() > 0) {
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
				}
				else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("No Price Found");
					wb.write(fos);
				}
				driver.close();
				driver.switchTo().window(parent);
			} else if (excelValue.contains("RGD")) {
				js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_RGD?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("AF")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_AF?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("CP")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_CP?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("NA")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_NA?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("SHP")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_SHP?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BGL")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BGL?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				}
				else if (excelValue.contains("BLL")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BLL?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BN")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BN?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				}
				else if (excelValue.contains("HG1")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HG1?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("HP1")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HP1?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				}
				else if (excelValue.contains("VS")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_VS?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);

				}else if (excelValue.contains("-0")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_0?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("-7")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_7?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} 
				else if (excelValue.contains("K4")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_K4?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				} 
				
				else if (excelValue.contains("MWF")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_MWF?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				}
				else if (excelValue.contains("PSH")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_PSH?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				}
				else if (excelValue.contains("N21")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_N21?$SwatchSS$']"))
							.click();
					List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
					if(Pri.size() > 0) {
						String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(price);
						wb.write(fos);
					}
					else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("No Price Found");
						wb.write(fos);
					}
					driver.close();
					driver.switchTo().window(parent);
				}
				else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("No Colour Match Found");
					wb.write(fos);
//					driver.quit();
				}

			} else {
				List<WebElement> Pri=driver.findElements(By.xpath("//span[@class='value']"));
				if(Pri.size() > 0) {
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(price);
					wb.write(fos);
				}
				else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("No Price Found");
					wb.write(fos);
				}
//				driver.quit();
			}

		}

	}

}