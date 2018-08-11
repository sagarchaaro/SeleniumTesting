package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		System.out.println("HDFC Netbanking url is launched");
		driver.manage().window().maximize();
		Thread.sleep(10000);		
		TargetLocator loc=driver.switchTo();
		loc.frame("login_page");
		driver.switchTo().frame(driver.findElement(By.xpath("*//frame[@name='login_page']")));
		/*List frames=driver.findElements(By.tagName("frame"));
		int size=frames.size();
		System.out.println("Number of frames are: "+size);
		driver.switchTo().frame(0);*/
		System.out.println("switched into Frame");
		driver.findElement(By.xpath("*//img[@alt='continue']")).click();
		System.out.println("Proceed button is clicked.");
		Thread.sleep(1000);
		Alert a=driver.switchTo().alert();
		Thread.sleep(1000);
		a.accept();
		System.out.println("Popup button is clicked");
		
	}
}
