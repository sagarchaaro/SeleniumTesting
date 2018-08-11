package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutoeDemo {
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String domainName=js.executeScript("return document.domain;").toString();
		System.out.println("Domain Name is: "+domainName);
		
		String sURL=js.executeScript("return document.URL;").toString();
		System.out.println("Url Name is: "+sURL);
		
		String sTitle=js.executeScript("return document.title").toString();
		System.out.println("Title is: "+sTitle);
		
		js.executeScript("window.scrollBy(0,100)");
		
		js.executeScript("history.go[0]");
		
		js.executeScript("window.location='https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#'");
		
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("*//span[text()='Next']"));
		js.executeScript("arguments[0].click();", element);
		
		//driver.close();
		
	}
}
