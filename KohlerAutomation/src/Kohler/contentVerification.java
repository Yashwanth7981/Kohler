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

public class contentVerification {

//	@Test
//	public void pv() throws Throwable {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://plumbingindia.kohler.test.us.onehippo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		for (int i =1278; i  <=1278; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet5");
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

			 if (b.size() > 0) {
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
					
					
					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);

				} 
				
				
				else if (excelValue.contains("BV")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BV?$SwatchSS$']"))
							.click();
					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
					
				} 
				
				else if (excelValue.contains("MS1")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_MS1?$SwatchSS$']"))
							.click();
					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
					
				} 
				
				
				else if (excelValue.contains("N21")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_N21?$SwatchSS$']"))
							.click();
					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
					
				} 
				
				else if (excelValue.contains("-96")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_96?$SwatchSS$']"))
							.click();
					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				}
				
				else if (excelValue.contains("DGS")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_DGS?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1= new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("RGD")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_RGD?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("AF")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_AF?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("CP")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_CP?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
					} else if (excelValue.contains("NA")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_NA?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("SHP")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_SHP?$SwatchSS$']"))
							.click();
					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BGL")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BGL?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BLL")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BLL?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("BN")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BN?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("HG1")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HG1?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("HP1")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HP1?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} else if (excelValue.contains("VS")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_VS?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);

				} else if (excelValue.contains("K4")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_K4?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);

				} else if (excelValue.contains("-7")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_7?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				}
				else if (excelValue.contains("-0")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_0?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				} 
				else if (excelValue.contains("MWF")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_MWF?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				}
				
				else if (excelValue.contains("PGD")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_PGD?$SwatchSS$']"))
							.click();

					

					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				}
				
				else if (excelValue.contains("PSH")) {
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_PSH?$SwatchSS$']"))
							.click();

					
					// Brand Name
					List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
					if (b1.size() > 0) {
						String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue(Brand);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(3).setCellValue("");
						wb.write(fos);
					}
					// Short Description
					List<WebElement> b2 = driver
							.findElements(By.xpath("//div[@class='koh-product-short-description']"));
					if (b2.size() > 0) {
						String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue(ShortDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(4).setCellValue("");
						wb.write(fos);
					}

					// Long Description
					List<WebElement> b3 = driver
							.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
					if (b3.size() > 0) {
						String longDes = driver
								.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue(longDes);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(5).setCellValue("");
						wb.write(fos);
					}
					// Collection
					List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
					if (b4.size() > 0) {
						String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue(Collection);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(6).setCellValue("");
						wb.write(fos);
					}
					// Installation
					List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
					if (b5.size() > 0) {
						String Installation = driver
								.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
						
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue(Installation);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(7).setCellValue("");
						wb.write(fos);
					}
					// Section
					List<WebElement> b6 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
					if (b6.size() > 0) {
						String Section = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue(Section);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(8).setCellValue("");
						wb.write(fos);
					}
//					 Category
					List<WebElement> b7 = driver.findElements(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
					if (b7.size() > 0) {
						String Category = driver.findElement(By.xpath(
								"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
								.getText();
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue(Category);
						wb.write(fos);
					} else {
						FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(9).setCellValue("");
						wb.write(fos);
					}
			
//					F1
					List<WebElement> b10 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
					if (b10.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
								.getText();
						r.createCell(10).setCellValue(F1);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(10).setCellValue("");
						wb.write(fos1);
					}
//					F2
					List<WebElement> b11 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
					if (b11.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
								.getText();
						r.createCell(11).setCellValue(F2);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(11).setCellValue("");
						wb.write(fos1);
					}
//					F3
					List<WebElement> b12 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
					if (b12.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
								.getText();
						r.createCell(12).setCellValue(F3);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(12).setCellValue("");
						wb.write(fos1);
					}
//					F4
					List<WebElement> b13 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
					if (b13.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
								.getText();
						r.createCell(13).setCellValue(F4);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(13).setCellValue("");
						wb.write(fos1);
					}
//					F5
					List<WebElement> b14 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
					if (b14.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
								.getText();
						r.createCell(14).setCellValue(F5);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(14).setCellValue("");
						wb.write(fos1);
					}
//					F6
					List<WebElement> b15 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
					if (b15.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
								.getText();
						r.createCell(15).setCellValue(F6);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(15).setCellValue("");
						wb.write(fos1);
					}
//					F7
					List<WebElement> b16 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
					if (b16.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
								.getText();
						r.createCell(16).setCellValue(F7);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(16).setCellValue("");
						wb.write(fos1);
					}
//					F8
					List<WebElement> b17 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
					if (b17.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
								.getText();
						r.createCell(17).setCellValue(F8);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(17).setCellValue("");
						wb.write(fos1);
					}
//					F9
					List<WebElement> b18 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
					if (b18.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
								.getText();
						r.createCell(18).setCellValue(F9);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(18).setCellValue("");
						wb.write(fos1);
					}
//					F10
					List<WebElement> b19 = driver
							.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
					if (b19.size() > 0) {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
								.getText();
						r.createCell(19).setCellValue(F10);
						wb.write(fos1);
					} else {
						FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
						r.createCell(19).setCellValue("");
						wb.write(fos1);
					}

					driver.close();
					driver.switchTo().window(parent);
				}
				else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("No Colour Match Found");
					wb.write(fos);
					driver.close();
					driver.switchTo().window(parent);
//					driver.quit();
				}

			} else {

				// Brand Name
				List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
				if (b1.size() > 0) {
					String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(Brand);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("");
					wb.write(fos);
				}
				// Short Description
				List<WebElement> b2 = driver
						.findElements(By.xpath("//div[@class='koh-product-short-description']"));
				if (b2.size() > 0) {
					String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
							.getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(4).setCellValue(ShortDes);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(4).setCellValue("");
					wb.write(fos);
				}

				// Long Description
				List<WebElement> b3 = driver
						.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
				if (b3.size() > 0) {
					String longDes = driver
							.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
							.getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(5).setCellValue(longDes);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(5).setCellValue("");
					wb.write(fos);
				}
				// Collection
				List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
				if (b4.size() > 0) {
					String Collection = driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][1]"))
							.getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(6).setCellValue(Collection);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(6).setCellValue("");
					wb.write(fos);
				}
				// Installation
				List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
				if (b5.size() > 0) {
					String Installation = driver
							.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[@class='koh-product-col-description'][2]")).getText();
					
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(7).setCellValue(Installation);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(7).setCellValue("");
					wb.write(fos);
				}
				// Section
				List<WebElement> b6 = driver.findElements(By.xpath(
						"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
				if (b6.size() > 0) {
					String Section = driver.findElement(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"))
							.getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(8).setCellValue(Section);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(8).setCellValue("");
					wb.write(fos);
				}
//				 Category
				List<WebElement> b7 = driver.findElements(By.xpath(
						"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
				if (b7.size() > 0) {
					String Category = driver.findElement(By.xpath(
							"//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"))
							.getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(9).setCellValue(Category);
					wb.write(fos);
				} else {
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(9).setCellValue("");
					wb.write(fos);
				}
		
//				F1
				List<WebElement> b10 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
				if (b10.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]"))
							.getText();
					r.createCell(10).setCellValue(F1);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(10).setCellValue("");
					wb.write(fos1);
				}
//				F2
				List<WebElement> b11 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
				if (b11.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]"))
							.getText();
					r.createCell(11).setCellValue(F2);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(11).setCellValue("");
					wb.write(fos1);
				}
//				F3
				List<WebElement> b12 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
				if (b12.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]"))
							.getText();
					r.createCell(12).setCellValue(F3);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(12).setCellValue("");
					wb.write(fos1);
				}
//				F4
				List<WebElement> b13 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
				if (b13.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]"))
							.getText();
					r.createCell(13).setCellValue(F4);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(13).setCellValue("");
					wb.write(fos1);
				}
//				F5
				List<WebElement> b14 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
				if (b14.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]"))
							.getText();
					r.createCell(14).setCellValue(F5);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(14).setCellValue("");
					wb.write(fos1);
				}
//				F6
				List<WebElement> b15 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
				if (b15.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]"))
							.getText();
					r.createCell(15).setCellValue(F6);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(15).setCellValue("");
					wb.write(fos1);
				}
//				F7
				List<WebElement> b16 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
				if (b16.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]"))
							.getText();
					r.createCell(16).setCellValue(F7);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(16).setCellValue("");
					wb.write(fos1);
				}
//				F8
				List<WebElement> b17 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
				if (b17.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]"))
							.getText();
					r.createCell(17).setCellValue(F8);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(17).setCellValue("");
					wb.write(fos1);
				}
//				F9
				List<WebElement> b18 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
				if (b18.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]"))
							.getText();
					r.createCell(18).setCellValue(F9);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(18).setCellValue("");
					wb.write(fos1);
				}
//				F10
				List<WebElement> b19 = driver
						.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
				if (b19.size() > 0) {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]"))
							.getText();
					r.createCell(19).setCellValue(F10);
					wb.write(fos1);
				} else {
					FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(19).setCellValue("");
					wb.write(fos1);
				}

//				driver.quit();
			}

		}

	}

}