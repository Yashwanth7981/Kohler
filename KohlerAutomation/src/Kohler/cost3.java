package Kohler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cost3 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		System.out.println("29959IN-BV");
		driver.get("http://kohler.co.in/");
		driver.manage().window().maximize();
		String excelValue="29959IN-BV";
		driver.findElement(
				By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys(excelValue + Keys.ENTER);
		Thread.sleep(6000);	
		if(excelValue.contains("BV")) {			
			driver.findElement(By.xpath("//span[@data-koh-color='Vibrant French Gold']")).click();
			String Value=driver.findElement(By.xpath("//span[@class='value']")).getText();
			System.out.println(Value);
		}
		else {
			System.out.println("Fasle");
		}
		
		
		
//		driver.findElement(By.xpath("//button[@data-hasqtip='swatch00']")).click();
//		String SKU=driver.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']")).getText();
//		if(SKU.equals("K-29959IN-BV")){
//			String price=driver.findElement(By.xpath("//span[@class='value']")).getText();
//			System.out.println(price);			
//		//	driver.quit();
//		}
//		else if (SKU.equals("K-29959IN-BV")){
//			driver.findElement(By.xpath("//button[@data-hasqtip='swatch01']")).click();
//			String SKU1=driver.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']")).getText();
//			if(SKU1.equals("K-29959IN-BV")){
//			String price=driver.findElement(By.xpath("//span[@class='value']")).getText();
//			System.out.println(price);			
//			//driver.quit();
//			}
//			else {
//			}
//		}
//		else if (SKU.equals("K-29959IN-BV")){
//				driver.findElement(By.xpath("//button[@data-hasqtip='swatch02']")).click();
//				String SKU2=driver.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']")).getText();
//				if(SKU2.equals("K-29959IN-BV")){
//				String price=driver.findElement(By.xpath("//span[@class='value']")).getText();
//				System.out.println(price);			
//			//	driver.quit();
//				}
//				else {
//				}
//		}
//		else if (SKU.equals("K-29959IN-BV")){
//			driver.findElement(By.xpath("//button[@data-hasqtip='swatch03']")).click();
//			String SKU3=driver.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']")).getText();
//			if(SKU3.equals("K-29959IN-BV")){
//			String price=driver.findElement(By.xpath("//span[@class='value']")).getText();
//			System.out.println(price);			
//		//	driver.quit();
//			}
//			else {
//			}
//	}
//		else if (SKU.equals("K-29959IN-BV")){
//			driver.findElement(By.xpath("//button[@data-hasqtip='swatch04']")).click();
//			String SKU4=driver.findElement(By.xpath("//div[@class='koh-product-skus-colors']/span[@class='koh-product-sku']")).getText();
//			if(SKU4.equals("K-29959IN-BV")){
//			String price=driver.findElement(By.xpath("//span[@class='value']")).getText();
//			System.out.println(price);			
//		//	driver.quit();
//			}
//			else {
//			}
//	}
//		else {
//		//	driver.quit();
//		}
				
	}
		
}

