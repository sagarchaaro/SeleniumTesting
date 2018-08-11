package login.com.orangehemlive.demo.opensource;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenshotDemo {
	static WebDriver driver;
	public static void printScreenshot(String FileName) throws Exception{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		File f1=new File("C:\\selenium\\eclipse workspace\\Test data\\screenshots\\"+FileName+".jpg");
		FileUtils.copyFile(f, f1);
	}
	
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		printScreenshot("Google1");
		driver.findElement(By.id("lst-ib")).sendKeys("India");
		//driver.findElement(By.id("lst-ib")).submit();
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		printScreenshot("Google2");
		driver.close();
		
		
		
	}
}
