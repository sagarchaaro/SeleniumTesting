package login.com.orangehemlive.demo.opensource;

import java.io.File;
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

public class ExcelLogin {
	static WebDriver driver;
	public static void openBrowser(String Browser) throws Exception
	{
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();	
		}else if(Browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Firefox\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\IE\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();			
		}else {
			System.out.println("Invalid browser");
		}
	}
	
	public static void main(String args[]) throws Exception{
		System.out.println(new File(".").getAbsoluteFile());
		
		FileInputStream fis=new FileInputStream("D:\\Workspace\\Test Data\\Login.xlsx");
		XSSFWorkbook wbk=new XSSFWorkbook(fis);
		XSSFSheet sh=wbk.getSheet("Login");
		XSSFRow row= sh.getRow(2);
		XSSFCell cell=row.getCell(0);
		String Excelbrowser=cell.getStringCellValue();
		System.out.println("Excel Browser is: "+Excelbrowser);
		openBrowser(Excelbrowser);
		String s1=wbk.getSheetAt(0).getRow(2).getCell(2).getStringCellValue();
		String s2=wbk.getSheetAt(0).getRow(2).getCell(3).getStringCellValue();
		System.out.println("Excel Browser is: "+s1);
		System.out.println("Excel Browser is: "+s2);
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
		System.out.println("Gmail website is launched");
		driver.findElement(By.name("identifier")).sendKeys(s1);
		System.out.println("email id is entered in text-box");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		System.out.println("Next button is clicked");
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(s2);
		System.out.println("password is entered in text-box");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		System.out.println("next button is clicked");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[@class='gb_db gbii']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='Account Information']")).click();
		System.out.println("account information is clicked");
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//a[@href='https://accounts.google.com/Logout']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		System.out.println("Sign out is clicked");
		driver.close();
		System.out.println("browser is closed");
	}
}
