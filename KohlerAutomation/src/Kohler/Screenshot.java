package Kohler;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://youngsoft.in/solutions/devops/");
		String loginTitle = driver.getTitle();
		 System.out.println(loginTitle);
		String expectedUrl = "DevOpsvghj";
		if (loginTitle.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Test passed");
		} else {
			TakesScreenshot SS = (TakesScreenshot) driver;
			File Src = SS.getScreenshotAs(OutputType.FILE);
			File Dest = new File("C:\\ScreenShot Selenium\\.jpg");
			Files.copy(Src, Dest);
			System.out.println("Screenshot Taken");
		}
	}
}
