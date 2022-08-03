package TestNG1;

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
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verify {
	@Test(priority=1)
public void verify() {
	
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    driver.get("http://kohler.co.in/");
	String x=driver.getTitle();
	Assert.assertEquals(x,"Kohler Faucets, Bathroom Sinks, Toilets, Showering | Kohler");
		
}
	@Test(priority=2)
public void cost() throws Exception {
		
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
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue("Product Not Found");
					wb.write(fos);
					driver.quit();

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
					Thread.sleep(6000);
					String a1 = driver
							.findElement(By.xpath("//div[@class='koh-product-skus-colors']//ul//span[@class='value']"))
							.getText();
					FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
					r.createCell(3).setCellValue(a1);
					wb.write(fos);
					driver.quit();

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
	

