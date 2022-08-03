package Kohler;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Incubators {

	public static void main(String[] args) throws Throwable {
		
	 
		for(int i=1;i<=66;i++) {
		FileInputStream fis = new FileInputStream("./Data/incubators.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Worksheet");
		Row r = sh.getRow(i);
		Cell c = r.getCell(1);
		String excelValue=c.getStringCellValue();
		System.out.println(excelValue);
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
   	    WebDriver driver = new ChromeDriver();
		driver.get("https://sit.sanchivillage.com/incubators/index/index/");
		driver.manage().window().maximize();
		driver.findElement(By.id("incubators")).sendKeys(excelValue+Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		TakesScreenshot SS = (TakesScreenshot) driver;
//		File Src = SS.getScreenshotAs(OutputType.FILE);
//		File Dest = new File("C:\\ScreenShot Selenium\\r.jpg");
//		Files.copy(Src, Dest);
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
	}
	
}
}


