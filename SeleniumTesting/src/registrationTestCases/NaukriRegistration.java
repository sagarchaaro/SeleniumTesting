package registrationTestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.BaseClass;
import pageObjects.Naukri_Page;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.Log;
import utilities.RandomFunctions;
import utilities.Utils;

public class NaukriRegistration {
	
	static WebDriver driver;
	static int iTestCaseRow;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	static ExtentTest logger;
	static Logger log4j;
	
	@BeforeClass
	public static void startWebDriver() throws Exception{
		log4j=Logger.getLogger("NaukiriRegistration");
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.xml");
		Log.startTestCase("Naukiri Registration");
		String dateandtime=Utils.generateCurrentDatewithTimeStamp();
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\NaukiriRegistration-"+dateandtime+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows7");
		report.setSystemInfo("Host Name", "Vijetha");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Vijetha Akkinapally");
		
		htmlReporter.config().setDocumentTitle("NaukiriRegistration");
		htmlReporter.config().setReportName("Naukiri - Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		iTestCaseRow=ExcelConfig.getRow(Constant.registrationstestDataPath, Constant.Sheet_naukiri);
		Log.info("Matched Test Row is: "+iTestCaseRow);
		driver=Utils.openBrowser();
		Log.info("Browser is Launched");
		new BaseClass(driver);
		Log.info("driver instance is passed to BaseClass driver");
		driver.get("https://my.naukri.com/account/createaccount");
		driver.manage().window().maximize();
		Log.info("naukiri account website is launched");
		Naukri_Page.lnk_IamFresher().click();
		Utils.printScreenShot(driver, "NaukriSignUpPage");
		Log.info("fresher button is clicked");
	}
	
	@Test
	public static void main() throws Exception{
		
		logger=report.createTest("NaukiriRegistration");
		//user name
		String sUserName=RandomFunctions.randomString(8);
		Log.info("generating the username using random function"+sUserName);
		ExcelConfig.setCellData(sUserName, iTestCaseRow,Constant.col_na_Name);
		Naukri_Page.txtbx_FirstName().sendKeys(sUserName);
		Utils.printScreenShot(driver, "FirstName");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"FirstName"+".jpg").build());
		Log.info("First name from random function is " +sUserName);
		
		//email
		String sEmail=RandomFunctions.randomEmail(10);
		Log.info("generating the email using random function" +sEmail);
		ExcelConfig.setCellData(sEmail,iTestCaseRow,Constant.col_na_Email);
		Log.info("setting the email value in excel sheet");
		Naukri_Page.txtbx_email().sendKeys(sEmail);
		Utils.printScreenShot(driver, "email");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"email"+".jpg").build());
		Log.info("email is entered in text box" +sEmail);
		
		//password
		String sPassowrd =ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_CreatePassword);
		Log.info("password  from test data sheet is " +sPassowrd);
		Naukri_Page.txtbx_createPassword().sendKeys(sPassowrd);
		Utils.printScreenShot(driver, "Password");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Password"+".jpg").build());
		Log.info(sPassowrd+ "is enetered as a password in a text-box");
		
		//mobile
		String sMobile =ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_mobile);
		Log.info("mobile  from test data sheet is" +sMobile);
		Naukri_Page.txtbx_mobile().sendKeys(sMobile);
		Utils.printScreenShot(driver, "mobile");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"mobile"+".jpg").build());
		Log.info(sMobile+ "is enetered as a mobile in a text-box");
		
		//current location
		Naukri_Page.drpdwn_currlocArrow().click();
		Utils.printScreenShot(driver, "CuuLocArrw");
		Log.info("Current location drop down arrow is clicked");
		String sLocation=ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_currentLocation);
		Log.info("location from test data sheet is" +sLocation);
		Naukri_Page.drpdwn_currlocation().sendKeys(sLocation);
		Utils.printScreenShot(driver, "CurrentLocation");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"CurrentLocation"+".jpg").build());
		Log.info(sLocation+ "is enetred from drop down list");
		Naukri_Page.drpdwn_currlocation().sendKeys(Keys.ARROW_DOWN);
		Naukri_Page.drpdwn_currlocation().sendKeys(Keys.ENTER);
		Log.info("location is selected from drop down");
		
		//Resume
		Naukri_Page.lnk_CopyResume().click();
		Utils.printScreenShot(driver, "CopResume");
		Log.info("Clicked on copy-paste your resume here link");
		String sResume =ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_resume);		
		Log.info("resume from test data sheet" +sResume);
		Naukri_Page.txtbx_PasteResume().sendKeys(sResume);
		Utils.printScreenShot(driver, "Pasteresume");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Pasteresume"+".jpg").build());
		Log.info(sResume+ "is entered in resume text box");
		
		//regitser now button
		Naukri_Page.btn_RegisterNow().click();
		Utils.printScreenShot(driver, "RegisterNow");
		Log.info("Clicked on register now button");
		
		//qualification
		//driver.findElement(By.xpath("(//span[@class='ddIcon srchTxt'])[1]")).click();
		String qualification= ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_Highest_Qualification);
		Log.info("qualification is " +qualification);
		driver.findElement(By.xpath("(//input[@name='qualification_0']")).sendKeys(qualification);
		driver.findElement(By.xpath("(//span[@class='ddIcon srchTxt'])[2]")).click();
		
		//course
		String course=ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_course);
		Log.info("course is " +course);
		driver.findElement(By.xpath("(//input[@name='course_0']")).sendKeys(course);
		driver.findElement(By.xpath("(//span[@class='ddIcon srchTxt'])[3]")).click();
		
		//specialization
		String specilaization=ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_Specialization);
		Log.info("specilaization is " +specilaization);
		driver.findElement(By.xpath("//input[@name='spec_0']")).sendKeys(specilaization);
		
		//college
		String college=ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_college);
		Log.info("college is " +college);
		driver.findElement(By.xpath("(//input[@class='sugInp'])[1]")).sendKeys(college);
		driver.findElement(By.xpath("(//label[@class='customRadioLbl'])[1]")).click();
		String yearofpass=ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_passin_year);
		Log.info("college is " +yearofpass);
		driver.findElement(By.xpath("//input[@name='yearOfCompletion_0']")).sendKeys(yearofpass);
		String skills=ExcelConfig.getCellData(iTestCaseRow,Constant.col_na_skills);
		Log.info("college is " +skills);
		driver.findElement(By.xpath("//input[@name='keyskills']")).sendKeys(skills);
		driver.findElement(By.xpath("//button[@name='submitEducationDetail']")).click();
		
		
		
		
	}
}
