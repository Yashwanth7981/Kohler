package Kohler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksChecker {
    public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://youngsoft.com/";
        driver.get(baseUrl);
       driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.startsWith("mailto:")) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int statusCode = connection.getResponseCode();
                    if (statusCode >= 400) {
                        System.out.println(url + " is a broken link");
                    } else {
                        System.out.println(url + " is a valid link");
                    }
                } catch (Exception e) {
                    System.out.println(url + " is a broken link");
                }

                
            }
        }

        driver.quit();
    }
}
