package Kohler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KohlerMarch {

	public static void main(String[] args) throws Throwable {
		for(int i=1;i<=96;i++) {
		FileInputStream fis = new FileInputStream("./Data/Kohler March2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Consolidated");
		Row r = sh.getRow(i);
		Cell c = r.getCell(1);
		String excelValue=c.getStringCellValue();
 		fis.close();
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
   	    WebDriver driver = new ChromeDriver();
   	    System.out.println(excelValue);  	     	  
		driver.get("http://kohler.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
		.sendKeys(excelValue);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']//span[2]//span//button//span")).click();
 		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String Result=driver.findElement(By.xpath("//div[@class='koh-result-nofilter']/h3")).getText();
   	    if(Result=="Please try a different search") {
   	    	 System.out.println(excelValue + "Product Not Found");  	    	
   	    }
   	    else {
   	    	continue;
   	    } 
		Thread.sleep(13000);
		String a = driver.findElement(By.xpath("//div[@class='koh-product-skus-colors']//ul//span[@class='value']")).getText();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.close();
 	    FileOutputStream fos=new FileOutputStream("./Data/Kohler March.xlsx");
		r.createCell(3).setCellValue(a);
 	    wb.write(fos);
		
	}
	}

	
	}
