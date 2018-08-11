package registrationTestCases;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

import pageObjects.BaseClass;
import pageObjects.FB_Page;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.ExtentManager;
import utilities.Log;
import utilities.Utils;



public class FBRegistration {

	static WebDriver driver;
	static int iTestCaseRow;
	static ExtentReports report;
	static ExtentTest logger;
	static Logger log4j;
	static String testname;
	
	@BeforeClass
	public static void startWebDriver() throws Exception{
		//Initiating the ExtentReport and Log4J
		testname=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1);
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.xml");		
		report=ExtentManager.createInstance(testname);
		Log.startTestCase("FB Registration");
		
		iTestCaseRow=ExcelConfig.getRow(Constant.registrationstestDataPath, Constant.sheet_Fb);
		Log.info("Matched Test Row is: "+iTestCaseRow);
		driver=Utils.openBrowser();
		Log.info("Browser Launched");
		new BaseClass(driver);
		
		driver.get("https://www.facebook.com/r.php?locale=en_GB");
		//driver.manage().window().maximize();
		Utils.printScreenShot(driver,"FbSignUpPage");
		Log.info("facebook account website is launched");
	}
	
	@Test
	public static void main() throws Exception
	{
		logger=report.createTest("FBRegistration");
		
		//FirstName
		String tag=FB_Page.txtbx_FirstName().getTagName();
		Log.info("The current tag name is: "+tag);
		String sFirstName=ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_FirstName);
		Log.info("First name from test data sheet is " +sFirstName);
		FB_Page.txtbx_FirstName().sendKeys(sFirstName);
		Utils.printScreenShot(driver, "Firstname1");
		logger.log(Status.INFO, "First Name is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Firstname1"+".jpg").build());
		Log.info("First Name is entered");
		Log.info(sFirstName+ "is enetered as a first name in a text-box");
		
		//LastName
		String sLastName =ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_Surname);
		Log.info("Last name  from test data sheet is " +sLastName);
		FB_Page.txtbx_LastName().sendKeys(sLastName);
		System.out.println(sLastName+ "is enetered as a last name in a text-box");
		Utils.printScreenShot(driver, "surname");
		logger.log(Status.INFO, "Last Name is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"surname"+".jpg").build());
		Log.info("Last Name is entered");
		
		
		//Email Address
		String sMobileEmailAddress =ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_Mobilemailaddress);
		Log.info("Mobile/Email Address from test data sheet is " +sMobileEmailAddress);
		FB_Page.txbx_mobileEmailAddr().sendKeys(sMobileEmailAddress);
		Log.info(sMobileEmailAddress+ "is entered as email addressin text box");
		Utils.printScreenShot(driver, "EmailAddr");
		logger.log(Status.INFO, "Email Address is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"EmailAddr"+".jpg").build());
		Log.info("Email Address is entered");
		
		//Create Password
		String sCreatePassword =ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_Newpassword);
		Log.info("Create password from test data sheet is " +sCreatePassword);
		FB_Page.txbx_createPassword().sendKeys(sCreatePassword);
		Log.info(sCreatePassword+ "is entered as created password in text box");
		Utils.printScreenShot(driver, "CreatePasswd");
		logger.log(Status.INFO, "create password is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"CreatePasswd"+".jpg").build());
		Log.info("create password is entered");	
		
		//date
		String day=ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_date);
		WebElement Birthdate=FB_Page.drpdwn_BirthDate();
		Select obBirthdate=new Select(Birthdate);
		obBirthdate.selectByVisibleText(day);
		Log.info("The birthday is selected from frop down by using visible text method");
		Utils.printScreenShot(driver, "BirthDay");
		logger.log(Status.INFO, "Birthday is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"BirthDay"+".jpg").build());
		Log.info("Birthday is entered");
		
		//month
		String month=ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_month);
		WebElement Birthmonth=FB_Page.drpdwn_BirthMonth();
		Select obBirthmonth=new Select(Birthmonth);
		obBirthmonth.selectByVisibleText(month);
		Utils.printScreenShot(driver, "Birthmonth1");
		logger.log(Status.INFO, "Birth month is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Birthmonth1"+".jpg").build());
		Log.info("The birth month is selected from frop down by using visible text method");
		
		//year
		String year=ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_year);
		WebElement Birthyear=FB_Page.drpdwn_BirthYear();
		Select obBirthyear=new Select(Birthyear);
		obBirthyear.selectByVisibleText(year);
		Log.info("The birth year is selected from frop down by using visible text method");
		Utils.printScreenShot(driver, "Birthyear1");
		logger.log(Status.INFO, "Birth year is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Birthyear1"+".jpg").build());
		
		//Gender
		String rGender =ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_gender);
		System.out.println("gender from test data sheet is" +rGender);
		if (rGender.contains("Female"))
		{
			FB_Page.rdbtn_genderFem().click();
			Utils.printScreenShot(driver, "genderfem");
			logger.log(Status.INFO, "gender radion button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"genderfem"+".jpg").build());
			Log.info("Gender radio button is selected as female");
		}else {
			FB_Page.rdbtn_genderMale().click();
			Utils.printScreenShot(driver, "gendermal");
			Log.info("Gender radio button is selected as male");
			logger.log(Status.INFO, "gender radion button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"gendermal"+".jpg").build());
		}
		
		//Save button
		WebElement createAccountWebElement=FB_Page.btn_createAccount();
		boolean saveDisplay=createAccountWebElement.isDisplayed();
		if(saveDisplay) {
			Log.info("Create button is displayed");
			createAccountWebElement.click();
			Utils.printScreenShot(driver, "SubmitBtn");
			logger.log(Status.INFO, "submit button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"SubmitBtn"+".jpg").build());
			Thread.sleep(10000);
		}else {
			Log.info("Create button is not displayed");
		}
		Thread.sleep(5000);
		
		//SMS Code
		String sSmsCode= ExcelConfig.getCellData(iTestCaseRow,Constant .col_fb_smsCode);
		Log.info("sms code from test data sheet is " +sSmsCode);
		FB_Page.txbx_smsCode().sendKeys(sSmsCode);
		Log.info(sSmsCode+ "is entered as sms code in text box");
		Utils.printScreenShot(driver, "SMSCode1");
		logger.log(Status.INFO, "SMS code is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"SMSCode1"+".jpg").build());
		Log.info("SMS code is entered");
		
		//Continue
		FB_Page.btn_continue().click();
		Log.info("Continue button is clicked");
		Utils.printScreenShot(driver, "ContinueBtn");
		logger.log(Status.INFO, "Continue button is clicked", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"ContinueBtn"+".jpg").build());
		Log.info("Continue button is clicked");
		
		Thread.sleep(4000);
		String sMessageText=FB_Page.msg_txt().getAttribute("data-xui-error");	
		System.out.println("Message Text is:"+sMessageText);
		if(sMessageText.equalsIgnoreCase("Please enter a valid code.")) {
		Log.info("Test Case is Passed");
		}else {
			Log.info("Test Case is Failed");
		}
	}			
	@AfterMethod
	public static void getResults(ITestResult result) throws Exception{
		if(result.getStatus()==ITestResult.FAILURE) {
			
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
