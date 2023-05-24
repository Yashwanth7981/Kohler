import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testClass1 {
	
		public static void main(String[] args) throws Throwable { 
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://moovitapp.com/index/en/public_transit-lines-Hyderabad-5997-1631245");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//div[@class=\"lines-container agency-lines\"]/ul/li[1]")).click();
			
			String a=driver.findElement(By.xpath("//ul[@class='stops-list bordered']")).getText();
			System.out.println(a);
		
	}

}
