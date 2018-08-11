package login.com.orangehemlive.demo.opensource;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		System.out.println("HDFC bank url is loaded");
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(By.xpath("*//a[text()='Products']"));
		action.moveToElement(element).build().perform();
		System.out.println("mouse hover action is performed on Products link");
		WebElement element1=driver.findElement(By.xpath("(*//a[text()='Insurance'])[1]"));
		action.contextClick(element1).build().perform();
		System.out.println("Right click is performed on Insurance");
		
		//To Select the Second option from Right click
		Thread.sleep(2000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
	}
}
