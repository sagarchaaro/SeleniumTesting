package login.com.orangehemlive.demo.opensource;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		System.out.println("HDFC Netbanking url is launched");
		driver.manage().window().maximize();
		//Thread.sleep(10000);		
		/*TargetLocator loc=driver.switchTo();
		loc.frame("login_page");*/
		//driver.switchTo().frame(driver.findElement(By.xpath("*//frame[@name='login_page']")));
		List frames=driver.findElements(By.tagName("frame"));
		int size=frames.size();
		System.out.println("Number of frames are: "+size);
		driver.switchTo().frame(0);
		System.out.println("switched into Frame");
		driver.findElement(By.xpath("*//input[@class='input_password']")).sendKeys("We43242");
		
	}
}
