package login.com.orangehemlive.demo.opensource;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ERDemo {
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	static ExtentTest logger;
	static WebDriver driver;
	
	@BeforeClass
	public static void startup() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\ERDemo.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows7");
		report.setSystemInfo("Host Name", "Sagar");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Sagar Chakilala");
		
		htmlReporter.config().setDocumentTitle("ExtentReportDemo");
		htmlReporter.config().setReportName("Demo - Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.DARK);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public static void testPass() {
		logger=report.createTest("testLogin", "Test Case 01 Login functionality");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		logger.log(Status.INFO, "UserName is entered");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		logger.log(Status.INFO, "Password is entered");
		driver.findElement(By.id("btnLogin")).click();
		logger.log(Status.INFO, "Button is clicked");
		
	}
	@Test(priority=2)
	public static void testFail() throws Exception{
		logger=report.createTest("testLogout", "Test Case 02 Logout functionality");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		logger.log(Status.INFO, "Welcome Admin link is clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='fgsjdff']")).click();
		logger.log(Status.INFO, "Logout link is clicked");
		
		
		
	}
	@Test(priority=3)
	public static void testSkip() {
		logger=report.createTest("testAddEmployee", "Test Case 03 Add Employee functionality");
		throw new SkipException("Add Employee Test Case is not yet ready");
	}
	
	@AfterMethod
	public static void getResults(ITestResult result) throws Exception{
		if(result.getStatus()==ITestResult.FAILURE) {
			
			//logger.fail(MarkupHelper.createLabel("TestCase is Failed", ExtentColor.RED));
			//logger.fail(result.getThrowable());
			
			logger.log(Status.FAIL, MarkupHelper.createLabel("TestCase is Failed", ExtentColor.RED));
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\Screenshots\\Logout.jpg"));
			
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\Logout.jpg");
			
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass(MarkupHelper.createLabel("TestCase is PASSED", ExtentColor.GREEN));
			
		}else if(result.getStatus()==ITestResult.SKIP){
			logger.skip(MarkupHelper.createLabel("TestCase is SKIPPED", ExtentColor.YELLOW));
			logger.skip(result.getThrowable());
		}
	}


	@AfterClass
	public static void tearDown() {
		driver.close();
		report.flush();
	}
	
}
