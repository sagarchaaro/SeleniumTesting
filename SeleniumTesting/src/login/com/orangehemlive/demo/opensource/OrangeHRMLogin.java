package login.com.orangehemlive.demo.opensource;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OrangeHRMLogin {
	static WebDriver driver;
	public static void openBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();	
		}else if(browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Firefox\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\IE\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();			
		}else {
			System.out.println("Invalid browser");
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String arg[]) throws Exception{
		FileInputStream fis=new FileInputStream("D:\\Workspace\\Test Data\\Login.xlsx");
		XSSFWorkbook wbk=new XSSFWorkbook(fis);
		XSSFSheet sh=wbk.getSheet("Login");
		XSSFRow row= sh.getRow(1);
		XSSFCell cell=row.getCell(0);
		String Excelbrowser=cell.getStringCellValue();
		System.out.println("Excel Browser is: "+Excelbrowser);
		openBrowser(Excelbrowser);
		
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		System.out.println("OrangeHRM website is launched");
		String userName="";
		//UserName
		driver.findElement(By.name("txtUsername")).sendKeys(userName);
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
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		System.out.println("Welcome Admin button is clicked");
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("Logout button is clicked");
		
		driver.close();
		System.out.println("browser is closed");
		
	}
}
