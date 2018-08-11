package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GmailLogin {
	public static void main(String args[])throws Exception
	{
		System.setProperty("webdriver.ie.driver","D:\\Workspace\\Jars and Drivers\\Drivers\\IE\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
		System.out.println("Gmail website is launched");
		driver.findElement(By.id("Email")).sendKeys("nishchitaaradhya@gmail.com");
		System.out.println("email id is entered in text-box");
		
		driver.findElement(By.name("signIn")).click();
		System.out.println("Next button is clicked");
		Thread.sleep(5000);
		driver.findElement(By.id("Passwd")).sendKeys("snehasag9");
		System.out.println("password is entered in text-box");
		driver.findElement(By.name("signIn")).click();
		System.out.println("next button is clicked");
	
	
		
	}
}
