package login.com.orangehemlive.demo.opensource;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.makemytrip.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("*//input[@id='hp-widget__sfrom']")).clear();
		driver.findElement(By.xpath("*//input[@id='hp-widget__sfrom']")).sendKeys("New Delhi, India");
		Thread.sleep(1000);
		driver.findElement(By.xpath("*//input[@id='hp-widget__sfrom']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("*//input[@id='hp-widget__sTo']")).sendKeys("Goa, India ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("*//input[@id='hp-widget__sTo']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("*//button[text()='Search'][@id='searchBtn']")).click();
		//boolean b=driver.findElement(By.xpath("*//span[text()='Fare Calendar']")).isDisplayed();
		//System.out.println("Fare Calender dispalyed? : "+b);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(1, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class, NullPointerException.class);

			WebElement fareCaleneder = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
				  WebElement element=driver.findElement(By.xpath("*//span[text()='Fare Cal']"));
				  if(element.isDisplayed()) {
					  System.out.println("Fare Calender is displayed");
					  return element;
				  }else {
					  System.out.println("Fare Calender is not displayed");
					  element=null;
					  return element;
				  }
			  }
			});
		
	}
}
