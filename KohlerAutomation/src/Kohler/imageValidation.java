package Kohler;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class imageValidation {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://plumbingindia.kohler.test.us.onehippo.com/");
		driver.manage().window().maximize();
		for (int i = 1; i <= 2; i++) {
			FileInputStream fis = new FileInputStream("./Data/Cost.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet3");
			Row r = sh.getRow(i);
			Cell c = r.getCell(2);
			Cell c1 = r.getCell(4);
			String excelValue = c.getStringCellValue();
			fis.close();
			System.out.println(excelValue);
			driver.findElement(
					By.xpath("//div[@class='c-koh-site-search koh-desktop-nav']/form/span/input[@type='text']"))
					.sendKeys(excelValue + Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> b1 = driver.findElements(By.xpath("//li[@class='active']"));
			if (b1.size() > 0) {
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.xpath("//div[@class='koh-product-image']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				js1.executeScript("window.scrollBy(0,200)");
//				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//				driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
				Set<String> st = driver.getWindowHandles();
				Iterator<String> it = st.iterator();
				String parent = it.next();
				String child = it.next();
				driver.switchTo().window(parent);
				driver.switchTo().window(child);
				if (excelValue.contains("BL")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BL?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);

				} else if (excelValue.contains("BV")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BV?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);

				} else if (excelValue.contains("RGD")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_RGD?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("BLL")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BLL?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);

				} else if (excelValue.contains("BGL")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BGL?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("AF")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_AF?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("CP")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_CP?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("NA")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_NA?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("SHP")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_SHP?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);

				} else if (excelValue.contains("BN")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_BN?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("HG1")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HG1?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("HP1")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_HP1?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("VS")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_VS?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);

				} else if (excelValue.contains("DGS")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_DGS?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);

				} else if (excelValue.contains("-0")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_0?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("-7")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_7?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("K4")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_K4?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("PSH")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_PSH?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("MWF")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_MWF?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else if (excelValue.contains("N21")) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					driver.findElement(
							By.xpath("//img[@src='//s7g10.scene7.com/is/image/kohlerindia/swatch_N21?$SwatchSS$']"))
							.click();
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				} else {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,100)");
					TakesScreenshot SS = (TakesScreenshot) driver;
					File Src = SS.getScreenshotAs(OutputType.FILE);
					File Dest = new File("C:\\ScreenShot Selenium\\" + excelValue + ".jpg");
					Files.copy(Src, Dest);
					driver.close();
					driver.switchTo().window(parent);
					String excelValue1 = c1.getStringCellValue();
					fis.close();
					System.out.println(excelValue1);
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
					driver.get("https://kohler.scene7.com/is/image/PAWEB/" + excelValue1);
					TakesScreenshot SS1 = (TakesScreenshot) driver;
					File Src1 = SS1.getScreenshotAs(OutputType.FILE);
					File Dest1 = new File("C:\\ScreenShot Selenium\\" + excelValue1 + ".jpg");
					Files.copy(Src1, Dest1);
				}

			}
		}
	}
}
