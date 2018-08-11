package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLogin {
	public static void main(String args[])  throws Exception{

		
		System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Firefox\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("OrangeHRM website is launched");
		//UserName
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		System.out.println("Admin is entered in the UserName text-box");
		
		/*By userName=By.name("txtUsername");
		WebElement element1=driver.findElement(userName);
		element1.sendKeys("Admin");*/
		
		//Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		System.out.println("admin is entered in the password text-box");
		/*By password=By.id("txtPassword");
		WebElement element2=driver.findElement(password);
		element2.sendKeys("admin");*/
		
		//Login button
		driver.findElement(By.xpath("*//input[@name='Submit']")).click();
		System.out.println("Login button is clicked");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		System.out.println("Welcome Admin button is clicked");
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("Logout button is clicked");
		
		driver.close();
		System.out.println("browser is closed");
	
	}
}
