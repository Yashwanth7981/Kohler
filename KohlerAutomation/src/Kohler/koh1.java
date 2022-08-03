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

public class koh1 {

	public static void main(String[] args) throws Throwable {
		for (int i = 1; i <= 10; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(i);
			Cell c = r.getCell(1);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://kohler.co.in/");
			driver.manage().window().maximize();
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> b10 = driver
					.findElements(By.xpath("//*[contains(text(),'Please try a different search')]"));

//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
//			(If Product does not Exists)
			if (b10.size() > 0) {
				FileOutputStream fos1 = new FileOutputStream("./Data/Cost.xlsx");
				r.createCell(3).setCellValue("Product Not Found");
				wb.write(fos1);
 //    			driver.quit();
			} 
			
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		(Product with Multi Colour)
			List<WebElement> b = driver.findElements(By.xpath("//li[@class='active']"));
//			List<WebElement> b1 = driver.findElements(By.xpath("//button[@data-hasqtip='swatch00']"));
//			List<WebElement> b2 = driver.findElements(By.xpath("//button[@data-hasqtip='swatch01']"));
//			List<WebElement> b3 = driver.findElements(By.xpath("//button[@data-hasqtip='swatch02']"));
//			List<WebElement> b4 = driver.findElements(By.xpath("//button[@data-hasqtip='swatch03']"));
//			List<WebElement> b5 = driver.findElements(By.xpath("//button[@data-hasqtip='swatch04']"));
			  if (b.size() > 0) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.xpath("//div[@class='koh-product-image']")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Set<String> st = driver.getWindowHandles();
				Iterator<String> it = st.iterator();
				String parent = it.next();
				String child = it.next();
				driver.switchTo().window(parent);
				driver.switchTo().window(child);
				driver.findElement(By.xpath("//button[@data-hasqtip='swatch00']")).click();
				String SKU1 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
				String SKU10 = "K-" + excelValue;
				if(SKU1.equals(SKU10)) {
					FileOutputStream fos2 = new FileOutputStream("./Data/Cost.xlsx");
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					r.createCell(3).setCellValue(price);
					wb.write(fos2);
// 					driver.quit();
				}
				else {
				continue;
				}
				driver.findElement(By.xpath("//button[@data-hasqtip='swatch01']")).click();
				String SKU2 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
				String SKU20 = "K-" + excelValue;
				if(SKU2.equals(SKU20)) {
					FileOutputStream fos3 = new FileOutputStream("./Data/Cost.xlsx");
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					r.createCell(3).setCellValue(price);
					wb.write(fos3);
//					driver.quit();
				}
				else {
					continue;
				}
				driver.findElement(By.xpath("//button[@data-hasqtip='swatch02']")).click();
				String SKU3 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
				String SKU30 = "K-" + excelValue;
				if(SKU3.equals(SKU30)) {
					FileOutputStream fos4 = new FileOutputStream("./Data/Cost.xlsx");
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					r.createCell(3).setCellValue(price);
					wb.write(fos4);
//					driver.quit();
					
				}
          else {
        	  continue;
				}
				driver.findElement(By.xpath("//button[@data-hasqtip='swatch03']")).click();
				String SKU4 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
				String SKU40 = "K-" + excelValue;
				if(SKU4.equals(SKU40)) {
					FileOutputStream fos5 = new FileOutputStream("./Data/Cost.xlsx");
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					r.createCell(3).setCellValue(price);
					wb.write(fos5);
//					driver.quit();
				
			  }
				else {
					continue;
				}
				driver.findElement(By.xpath("//button[@data-hasqtip='swatch04']")).click();
				String SKU5 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
				String SKU50 = "K-" + excelValue;
				if(SKU5.equals(SKU50)) {
					FileOutputStream fos6 = new FileOutputStream("./Data/Cost.xlsx");
					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
					r.createCell(3).setCellValue(price);
					wb.write(fos6);
//					driver.quit();
				
			  }
				else {
					continue;
				}
				
			  }
		}
	}
}
				
				
				
				
				
				
				
//				
//				String SKU1 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
//				String SKU10 = "K-" + excelValue;
//				if(b1.size()>0 && ) {
				 
//					FileOutputStream fos2 = new FileOutputStream("./Data/Cost.xlsx");
//					String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
//					r.createCell(3).setCellValue(price);
//					wb.write(fos2);
//				driver.quit();
//				}
//				 else {
//					 
//				}
//			driver.findElement(By.xpath("//button[@data-hasqtip='swatch01']")).click();
//			String SKU2 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
//			String SKU20 = "K-" + excelValue;
//			if(b2.size()>0 && SKU2.equals(SKU20)) {
//			 
//				FileOutputStream fos3 = new FileOutputStream("./Data/Cost.xlsx");
//				String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
//				r.createCell(3).setCellValue(price);
//				wb.write(fos3);
////				driver.quit();
//			}
//			 else {
//			 }
//			
//			driver.findElement(By.xpath("//button[@data-hasqtip='swatch02']")).click();
//			String SKU3 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
//			String SKU30 = "K-" + excelValue;
//			if(b3.size()>0 && SKU3.equals(SKU30)) {		       
//				FileOutputStream fos4= new FileOutputStream("./Data/Cost.xlsx");
//				String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
//				r.createCell(3).setCellValue(price);
//				wb.write(fos4);
////				driver.quit();
//			} else {
//			}
//			
//			driver.findElement(By.xpath("//button[@data-hasqtip='swatch03']")).click();
//			String SKU4 = driver.findElement(By.xpath("//span[@class='koh-product-sku']")).getText();
//			String SKU40 = "K-" + excelValue;
//			if(b4.size()>0 && SKU4.equals(SKU40)) {
//			
//				FileOutputStream fos5= new FileOutputStream("./Data/Cost.xlsx");
//				String price = driver.findElement(By.xpath("//span[@class='value']")).getText();
//				r.createCell(3).setCellValue(price);
//				wb.write(fos5);
////				driver.quit();
//			} else {	
//			}
//			  }
//			  
//			
//			else {
//				String a1 = driver
//						.findElement(By.xpath("//div[@class='koh-product-skus-colors']//ul//span[@class='value']"))
//						.getText();
//				FileOutputStream fos = new FileOutputStream("./Data/cost.xlsx");
//				r.createCell(3).setCellValue(a1);
//				wb.write(fos);
//				driver.quit();
//				
//			}
//				
//			}
//
//		}
//	}

