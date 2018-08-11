package registrationTestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.BaseClass;
import pageObjects.Gmail_Page;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.Log;
import utilities.Utils;

public class GmailRegistration {

	static WebDriver driver;
	static int iTestCaseRow;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	static ExtentTest logger;
	static Logger log4j;
	
	@BeforeClass
	public static void startWebDriver() throws Exception{
		log4j=Logger.getLogger("GmailRegistration");
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.xml");
		Log.startTestCase("Gmail Registration");
		String dateAndTime=Utils.generateCurrentDatewithTimeStamp();
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\GmailRegistration-"+dateAndTime+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows7");
		report.setSystemInfo("Host Name", "Vijetha");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Vijetha Akkinapally");
		
		htmlReporter.config().setDocumentTitle("GmailRegistration");
		htmlReporter.config().setReportName("Gmail - Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		iTestCaseRow=ExcelConfig.getRow(Constant.registrationstestDataPath, Constant.sheet_Gmail);
		Log.info("Matched Test Row is: "+iTestCaseRow);
		driver= Utils.openBrowser();
		Log.info("Browser is Launched");
		new BaseClass(driver);
		Log.info("driver instance is passed to BaseClass driver");
		driver.get("https://accounts.google.com/SignUp?hl=en");
		Utils.printScreenShot(driver, "GmailSignUpPage");
		Log.info("gmail account website is launched");
		driver.manage().window().maximize();
		Log.info("Browser is maximized");	
	}
	
	
	@Test
	public static void  main() throws Exception{
		
		logger=report.createTest("GmailRegistration");
		//FirstName
		String sFirstName=ExcelConfig.getCellData(iTestCaseRow,Constant.col_Gmail_FirstName);
		Log.info("First name from test data sheet is " +sFirstName);
		Gmail_Page.txtbx_FirstName().sendKeys(sFirstName);
		Log.info(sFirstName+ "is entered as first name in text box");
		Utils.printScreenShot(driver, "firstname");
		logger.log(Status.INFO, "First Name is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"firstname"+".jpg").build());
		Log.info("First Name is entered");
		
		//Last Name
		String sLastName =ExcelConfig.getCellData(iTestCaseRow,Constant.col_Gmail_LastName);
		Log.info("Last name from test data sheet is " +sLastName);
		Gmail_Page.txtbx_LastName().sendKeys(sLastName);
		Log.info(sLastName+ "is entered as last name in text box");
		Utils.printScreenShot(driver, "lastname1");
		logger.log(Status.INFO, "Last Name is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"lastname1"+".jpg").build());
		Log.info("Last Name is entered");
		
		//userName
		String sUserName =ExcelConfig.getCellData(iTestCaseRow,Constant.col_gmail_UserName);
		Log.info("username from test data sheet is " +sUserName);
		Gmail_Page.txtbx_userName().sendKeys(sUserName);
		Utils.printScreenShot(driver, "username");
		logger.log(Status.INFO, "username is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"username"+".jpg").build());
		Log.info("username is entered");
		
		//Create password
		String sCreatePassword =ExcelConfig.getCellData(iTestCaseRow,Constant.col_Gmail_createPassword);
		Log.info("Create password from test data sheet is " +sCreatePassword);
		Gmail_Page.txtbx_CreatePasswd().sendKeys(sCreatePassword);
		Log.info(sCreatePassword+ "is entered as create password in text box ");
		Utils.printScreenShot(driver, "createpawd");
		logger.log(Status.INFO, "createpawd is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"createpawd"+".jpg").build());
		Log.info("createpawd is entered");
		
		//confirm password
		String sConfirmPassword =ExcelConfig.getCellData(iTestCaseRow,Constant.col_Gmail_confirmPassword);
		Log.info("confirm password from test data sheet is " +sConfirmPassword);
		Gmail_Page.txtbx_ConfmPasswd().sendKeys(sConfirmPassword);
		Log.info(sConfirmPassword+ "is entered as confirm password in text box");
		Utils.printScreenShot(driver, "cnfmPwsd");
		logger.log(Status.INFO, "confirm passwordd is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"cnfmPwsd"+".jpg").build());
		Log.info("confirm passwordd is entered");
		
		//Next button
		Gmail_Page.btn_next().click();
		Log.info("Next button is clicked");
		
		//mobile number
		String sMobileNumber =ExcelConfig.getCellData(iTestCaseRow,Constant.col_Gmail_mobile);
		Log.info("mobile number from test data sheet is " +sMobileNumber);
		Gmail_Page.txtbx_mobileNumber().sendKeys(sMobileNumber);
		Log.info(sMobileNumber+ "is entered as mobile number in text box");
		Utils.printScreenShot(driver, "mobileNumber");
		logger.log(Status.INFO, "mobile is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"mobileNumber"+".jpg").build());
		Log.info("mobile number is entered");
		
		//second next button
		Gmail_Page.btn_secondNext().click();
		Log.info("Next button is clicked after entering the mobile number");
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
		public static void teardown() {
			report.flush();
			driver.quit();
			Log.endTestCase();
	}

}
