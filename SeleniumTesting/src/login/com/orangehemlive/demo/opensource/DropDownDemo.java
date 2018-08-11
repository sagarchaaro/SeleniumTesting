package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		System.out.println("IRCTC Sign up page is opened");
		driver.manage().window().maximize();
		WebElement sq=driver.findElement(By.id("userRegistrationForm:securityQ"));
		Select s=new Select(sq);
		s.selectByIndex(5);
		System.out.println("favourite past time is selected");
		Thread.sleep(2000);
		//s.deselectByIndex(5);
		//System.out.println("De select by Index is completed");
		
	}
}
