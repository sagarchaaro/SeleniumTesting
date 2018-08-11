package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoITFileUploadDemo {

	static WebDriver driver;
	
	@Test
	public static void test() throws Exception {
		
			System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://seleniumlearns-trials641.orangehrmlive.com");
			System.out.println("OrangeHRM website is launched");
			driver.manage().window().maximize();
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			System.out.println("Username is entered");
			driver.findElement(By.id("txtPassword")).sendKeys("SeleniumTest");
			System.out.println("Password is entered");
			driver.findElement(By.id("btnLogin")).click();
			System.out.println("Login button is clicked");
			driver.findElement(By.xpath("//span[text()='PIM']")).click();
			System.out.println("PIM sub menu is clicked");
			driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
			System.out.println("Add employee sub menu is clicked");
			Thread.sleep(20000);
			
			driver.findElement(By.id("firstName")).sendKeys("Vijetha");
			System.out.println("First Name is entered");
			
			driver.findElement(By.id("middleName")).sendKeys("A");
			System.out.println("Middle Name is entered");
		
			driver.findElement(By.id("lastName")).sendKeys("Akkinapally");
			System.out.println("Last Name is entered");
			
			driver.findElement(By.id("employeeId")).clear();
		
			driver.findElement(By.id("employeeId")).sendKeys("54321");
			System.out.println("employee id is entered");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//label[@id='photo-preview-lable']")).click();
			Thread.sleep(2000);
			
			/*driver.findElement(By.xpath("(//input[@class='select-dropdown'])[2]")).click();
			System.out.println("Country drop down is clicked");*/
			
			
			Runtime.getRuntime().exec("‪‪C:\\Learning\\AutoITFiles\\FileUploadDemo.exe");
			
			/*int size= driver.findElement(By.xpath
			driver.findElement(By.xpath("//option[text()='India']")).click();
			System.out.println("Country is selected as india");
			
			driver.findElement(By.xpath("//a[text()='Save']")).click();
			System.out.println("save button is clicked");*/
	}
}
