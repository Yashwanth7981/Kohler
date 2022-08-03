package Kohler;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://kohler.co.in");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div//button[@class='windowclose']")).click();
		  List <WebElement > links=driver.findElements(By.tagName("a"));
		  System.out.println(links.size());
		  for(int i=0;i<links.size();i++)
		  {
			 WebElement element=links.get(i);
			String url= element.getAttribute("href");
			URL link=new URL(url);
			HttpURLConnection httpConn=(HttpURLConnection) link.openConnection();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			httpConn.connect();
			int rescode=httpConn.getResponseCode();
			if(rescode>=400) {
				
				System.out.println(url +" - "+" is broken link");	  
		  }
		  else
		  {
			  System.out.println(url +" - "+" is Valid link");
		  }
		  
		  }
		  
		
	}
}