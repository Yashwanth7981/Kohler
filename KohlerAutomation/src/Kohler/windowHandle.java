package Kohler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
   	    WebDriver driver = new ChromeDriver();
   	    driver.manage().window().maximize();
		driver.get("https://uat.sanchivillage.com/");
		

	}

}
