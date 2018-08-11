package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.bytebuddy.utility.RandomString;
import utilities.Constant;

public class Utils {
	
	public static String dateAndTime="";
	
	public static WebDriver openBrowser() throws Exception{
		
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		dc.setCapability("requireWindowFocus", true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("chrome.switches","-disable-extensions");
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		options.merge(dc);
		System.setProperty("webdriver.chrome.driver", Constant.chromeDriverPath);
		WebDriver driver=new ChromeDriver(options);
		Log.info("New Driver is instantiated for CHROME browser.");		
		driver.manage().timeouts().implicitlyWait(Constant.iImplicitWait, TimeUnit.SECONDS);
		Log.info("Implict wait is applied on the Driver for 10 seconds");
		return driver;
		
		
	}
	
	public static void  printScreenShot(WebDriver driver, String FileName) throws Exception
	{
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File f= ts.getScreenshotAs(OutputType.FILE);
		 File f1=new File(Constant.screenshotsPath+FileName+".jpg");
		 FileUtils.copyFile(f,f1);
	}
	
	public static boolean retryClick(WebDriver driver, By by) throws Exception{		
		boolean result = false;
		int attempts = 0;
		while(attempts < 2) {
			try {
					driver.findElement(by).click();
		            result = true;
		            break;
			} catch(StaleElementReferenceException e) {
			
			}
			attempts++;
		}
		return result;		
	}
	
	public static String setRandomString() throws Exception{
		RandomString r=new RandomString();
		@SuppressWarnings("static-access")
		String sData=r.make(8);
		return sData;
	}
	
	public static String generateCurrentDatewithTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);		
	}
}
