package Kohler;

import java.io.File;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class catofProd {

	public static void main(String[] args) throws Throwable { 
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://kohler.co.in");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("15399T-B-BV" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("15399T-B-BV" + Keys.ENTER);
		for (int i = 357; i <= 370; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet2");
			Row r = sh.getRow(i);
			Cell c = r.getCell(1);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.out.println(excelValue);
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> b = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/h1[2]/a"));
//			List<WebElement> b1 = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/p"));
			if (b.size() > 0) {
				
     			driver.findElement(By.xpath("//*[@id=\"koh-page-outer\"]/div/div[1]/div/div/h1[2]/a")).click();
     			
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				String Section=driver.findElement(By.xpath("//div[@class='koh-product-breadcrumb']/ul/li[2]/a")).getText();
				
				
				Set<String> st = driver.getWindowHandles();
				Iterator<String> it = st.iterator();
				String parent = it.next();
				String child = it.next();
				driver.switchTo().window(parent);
				driver.switchTo().window(child);
				TakesScreenshot SS = (TakesScreenshot) driver;
				File Src = SS.getScreenshotAs(OutputType.FILE);
				File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue +".jpg");
				Files.copy(Src, Dest);
				driver.close();
				driver.switchTo().window(parent);
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(4).setCellValue("Taken");
				wb.write(fos);
//				String Category=driver.findElement(By.xpath("//div[@class='koh-product-breadcrumb']/ul/li[3]/a")).getText();
//           	FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
//				r.createCell(5).setCellValue(Category);
//				wb.write(fos);
				
			}
			else  {
				FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(4).setCellValue("");
				wb.write(fos);
				
			}		
}
	}
}
