package Kohler;

import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class contentOfProducts {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://plumbingindia.kohler.test.us.onehippo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("98930X-1-0" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
				.sendKeys("20701-0" + Keys.ENTER);

//		// Brand Name
		List<WebElement> b1 = driver.findElements(By.xpath("//div[@class='koh-product-name']"));
		if(b1.size()>0) {
			String Brand = driver.findElement(By.xpath("//div[@class='koh-product-name']")).getText();
			System.out.println(Brand);
		}
		else {
			System.out.println("No Brand Found");
		}
		//Short Description
		List<WebElement> b2 = driver.findElements(By.xpath("//div[@class='koh-product-short-description']"));
		if (b2.size()>0) {
			String ShortDes = driver.findElement(By.xpath("//div[@class='koh-product-short-description']"))
					.getText();
			System.out.println(ShortDes);
		}
		else {
			System.out.println("No Short Description Found");
		}


//		// Collection
		List<WebElement> b4 = driver.findElements(By.xpath("//*[contains(text(),'Collection:')]"));
		if (b4.size() > 0) {
			String Collection = driver.findElement(By.xpath("//span[@class='koh-product-col-description']")).getText();
			System.out.println(Collection);
		} else {
			System.out.println("No Collection Found");
		}
		// Installation
		List<WebElement> b5 = driver.findElements(By.xpath("//*[contains(text(),'Installation:')]"));
		if(b5.size()>0) {
			String Installation =  driver.findElement(By.xpath("//div[@class='koh-product-specs-other']/span[4]")).getText();
			System.out.println(Installation);
		}
		else {
			System.out.println("No Installation Found");
		}
		// Section
		List<WebElement> b6 = driver.findElements(By.xpath("//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a"));
		if (b6.size()>0) {
			String Section=driver.findElement(By.xpath("//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[2]/a")).getText();
			System.out.println(Section);
		}
		else {
			System.out.println("No Section Found");
		}
		// Category 
		List<WebElement> b7 = driver.findElements(By.xpath("//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a"));
		if (b7.size()>0) {
			String Category=driver.findElement(By.xpath("//section[@class='c-koh-product-details v-koh-default c-koh-product-details-la c-koh-product-details-in']/div/ul/li[3]/a")).getText();
			System.out.println(Category);
		}
		else {
			System.out.println("No Category Found");
		}
		List<WebElement> b9 = driver.findElements(By.xpath("//div[@class='koh-product-features-description-files']/div"));
		if (b9.size() > 0) {
			String longDes = driver.findElement(By.xpath("//div[@class='koh-product-features-description-files']/div"))
					.getText();
			System.out.println(longDes);
		} else {
			System.out.println("No Long Description Found");
		}
		
		List<WebElement> b10 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[1]"));
		if (b10.size()>0) {
			String F1 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[1]")).getText();
			FileOutputStream fos = new FileOutputStream("./Data/Cost.xlsx");
//			r.createCell(3).setCellValue(Brand);
//			wb.write(fos);
		}
		else {
			System.out.println("No F1 Found");
		}
		List<WebElement> b11 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[2]"));
		if (b11.size()>0) {
			String F2 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[2]")).getText();
			System.out.println(F2);
		}
		else {
			System.out.println("No F2 Found");
		}
		List<WebElement> b12 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[3]"));
		if (b12.size()>0) {
			String F3 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[3]")).getText();
			System.out.println(F3);
		}
		else {
			System.out.println("No F3 Found");
		}
		List<WebElement> b13 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[4]"));
		if (b13.size()>0) {
			String F4 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[4]")).getText();
			System.out.println(F4);
		}
		else {
			System.out.println("No F4 Found");
		}
		List<WebElement> b14 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[5]"));
		if (b14.size()>0) {
			String F5 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[5]")).getText();
			System.out.println(F5);
		}
		else {
			System.out.println("No F5 Found");
		}
		List<WebElement> b15 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[6]"));
		if (b15.size()>0) {
			String F6 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[6]")).getText();
			System.out.println(F6);
		}
		else {
			System.out.println("No F6 Found");
		}
		List<WebElement> b16 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[7]"));
		if (b16.size()>0) {
			String F7 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[7]")).getText();
			System.out.println(F7);
		}
		else {
			System.out.println("No F7 Found");
		}
		List<WebElement> b17 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[8]"));
		if (b17.size()>0) {
			String F8 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[8]")).getText();
			System.out.println(F8);
		}
		else {
			System.out.println("No F8 Found");
		}
		List<WebElement> b18 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[9]"));
		if (b18.size()>0) {
			String F9 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[9]")).getText();
			System.out.println(F9);
		}
		else {
			System.out.println("No F9 Found");
		}
		List<WebElement> b19 = driver.findElements(By.xpath("//ul[@class='koh-product-features-general']/li[10]"));
		if (b19.size()>0) {
			String F10 = driver.findElement(By.xpath("//ul[@class='koh-product-features-general']/li[10]")).getText();
			System.out.println(F10);
		}
		else {
			System.out.println("No F10 Found");
		}
		
	}
}
