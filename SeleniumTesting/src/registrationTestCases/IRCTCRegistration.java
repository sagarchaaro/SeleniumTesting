package registrationTestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import pageObjects.IRCTC_Page;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.Log;
import utilities.Utils;

public class IRCTCRegistration {
	
	static WebDriver driver;
	static int iTestCaseRow;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	static ExtentTest logger;
	static Logger log4j;
	
	@BeforeClass
	public static void startup() throws Exception{
			log4j=Logger.getLogger("GmailRegistration");
			DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.xml");
			Log.startTestCase("IRCTC Registration");
			String dateandtime=Utils.generateCurrentDatewithTimeStamp();
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\IRCTCRegistration-"+dateandtime+".html");
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Windows7");
			report.setSystemInfo("Host Name", "Vijetha");
			report.setSystemInfo("Environment", "QA");
			report.setSystemInfo("User Name", "Vijetha Akkinapally");
			
			htmlReporter.config().setDocumentTitle("IRCTCRegistration");
			htmlReporter.config().setReportName("IRCTC - Extent Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			
			iTestCaseRow=ExcelConfig.getRow(Constant.registrationstestDataPath, Constant.Sheet_IRCTC);
			Log.info("Matched Test Row is: "+iTestCaseRow);
			driver=Utils.openBrowser();
			Log.info("Browser is Launched");
			new BaseClass(driver);
			Log.info("driver instance is passed to BaseClass driver");
			driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");		
			Log.info("irctc account website is launched");
			Utils.printScreenShot(driver, "IRCTCSignUpPage");
			driver.manage().window().maximize();
			Log.info("IRCTC Registration page is maximized");
	}
	@Test
	public static void main() throws Exception{
		
		logger=report.createTest("IRCTCRegistration");
		//User id
		String sUserid=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_userid);
		Log.info("UserID from Test Data sheet is: " +sUserid);
		IRCTC_Page.txtbx_UserId().sendKeys(sUserid);
		Log.info(sUserid+ " is enetered as a UserID in a text-box");
		Utils.printScreenShot(driver, "UserId");
		logger.log(Status.INFO, "user id is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"UserId"+".jpg").build());
		Log.info("user id is entered");
		
		//check user id availbility
		IRCTC_Page.lnk_chkAvail().click();
		Log.info("Click action is perfomed on Availablecheck link.");
		Utils.printScreenShot(driver, "ChkAvail"); 
		logger.log(Status.INFO, "link is clicked", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"ChkAvail"+".jpg").build());
		Log.info("link is clicked");
		
		//password
		String sPassword=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_password);
		Log.info("password from Test Data sheet is:" +sPassword);
		IRCTC_Page.txtbx_password().sendKeys(sPassword);
		Log.info(sPassword+ " is enetered as a password in a text-box");
		Utils.printScreenShot(driver, "password");
		logger.log(Status.INFO, "password is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"password"+".jpg").build());
		Log.info("Password is entered");
		
		//confirm password
		String sConfirmPassword=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_confirmpassword);
		Log.info("Confirm Password from test data sheet is " +sConfirmPassword);
		IRCTC_Page.txtbx_Confrmpassword().sendKeys(sConfirmPassword);
		Log.info(sConfirmPassword+ " is enetered as a  confrim password in a text-box");
		Utils.printScreenShot(driver, "Confirmpassword");
		logger.log(Status.INFO, "confirm password is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Confirmpassword"+".jpg").build());
		Log.info("confirm password is entered");
		
		
		//Security question
		WebElement wSecurityquestion = IRCTC_Page.drpdwn_securityquestion();
		Select obSecurityQuestion= new Select(wSecurityquestion);
		obSecurityQuestion.selectByIndex(2);
		Log.info("Secuirty question s selected from drop down by index value 2");
		Utils.printScreenShot(driver, "securityQuest");
		logger.log(Status.INFO, "sceurity question is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"securityQuest"+".jpg").build());
		Log.info("sceurity question entered");
		
		//securityanswer
		System.out.println("What was the name of your first school?");
		String sSecurityAnswer= ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_SecurityAnswer);
		Log.info("Secuirty answer from test data sheet" +sSecurityAnswer);
		IRCTC_Page.txtbx_SceurityAnswer().sendKeys(sSecurityAnswer);
		Log.info(sSecurityAnswer+ " is enetered as a security answer in a text-box");
		Utils.printScreenShot(driver, "SecurityAns");
		logger.log(Status.INFO, "sceurity answer is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"SecurityAns"+".jpg").build());
		Log.info("sceurity answer is entered");
		
		//preffered Language
		WebElement wPrefferedLanguage=IRCTC_Page.drpdwn_PlLanguage();
		Select obPrefferedLanguage= new Select(wPrefferedLanguage);
		obPrefferedLanguage.selectByVisibleText("English");
		Utils.printScreenShot(driver, "Language");
		logger.log(Status.INFO, "Preferred language is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Language"+".jpg").build());
		Log.info("Preferred language is selected from drop down value");
		
		//FirstName
		String sFirstname=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_FirstName);
		Log.info("Firstname from test data sheet is " +sFirstname);		
		IRCTC_Page.txtbx_Firstname().sendKeys(sFirstname);
		Log.info(sFirstname+ " is entered as firstname in a text box");	
		Utils.printScreenShot(driver, "firstname");
		logger.log(Status.INFO, "first name is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"firstname"+".jpg").build());
		Log.info("First name is entered");
		
		//MiddleName
		String sMiddlename=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_MiddleName);
		Log.info("Middlename from Test data sheet " +sMiddlename);		
		IRCTC_Page.txtbx_Middlename().sendKeys(sMiddlename);
		Log.info(sMiddlename+ " is entered as middlename in a text box");	
		Utils.printScreenShot(driver, "MiddleName");
		logger.log(Status.INFO, "MiddleName is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"MiddleName"+".jpg").build());
		Log.info("Middle name entered");
		
		//LastName
		String sLastname=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_LasttName);
		Log.info("Last name from test data sheet is" +sLastname);		
		IRCTC_Page.txtbx_Lastname().sendKeys(sLastname);
		Log.info(sLastname+ "is entered as lastname in a text box");
		Utils.printScreenShot(driver, "LastName");
		logger.log(Status.INFO, "LastName is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"LastName"+".jpg").build());
		Log.info("Last name entered");
		
		//Gender
		String rGender =ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_gender);
		Log.info("gender from test data sheet is" +rGender);
		if (rGender.contains("Female"))
		{
			IRCTC_Page.rdbtn_genderfem().click();
			Utils.printScreenShot(driver, "genfemale");
			Log.info("gender is selected as female and corresponding radio button is clicked");
			logger.log(Status.INFO, "gender female is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"genfemale"+".jpg").build());
			Log.info("gender female is selected ");
		}else {				
			IRCTC_Page.rdbtn_genderMale().click();
			Log.info("Gender is selected as male and corresponding radio button is clicked");
			Utils.printScreenShot(driver, "genmale");
			logger.log(Status.INFO, "gender male is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"genmale"+".jpg").build());
			Log.info("gender male is selected ");
		}
		
		
		
		//marital status
		String rMaritalStatus =ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_maritalStatus);
		Log.info("marital status  from test data sheet is " +rMaritalStatus);
		if(rMaritalStatus.contains("Married"))
		{			
			IRCTC_Page.rdbtn_married().click();
			Utils.printScreenShot(driver, "Married");
			Log.info("Maritalstatus selected as married and corresponding radio button is clicked");
			logger.log(Status.INFO, "married radio button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Married"+".jpg").build());
			Log.info("married radio button is selected");
		}else {
			 IRCTC_Page.rdbtn_Unmarried().click();
			 Log.info("Maritalstatus selected as unmarried and corresponding radio button is clicked");
			 Utils.printScreenShot(driver, "Unmarried");
			 logger.log(Status.INFO, "Unmarried radio button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Unmarried"+".jpg").build());
				Log.info("Unmarried radio button is selected");
		}
		
		
		//Birthday
		WebElement wBirthday=IRCTC_Page.drpdwn_birthday();
		Select obBirthday= new Select(wBirthday);
		obBirthday.selectByIndex(13);
		Utils.printScreenShot(driver, "BirthDay");
		Log.info("Birthday is selected from dropdown value by using index value");
		logger.log(Status.INFO, "Birthday is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"BirthDay"+".jpg").build());
		Log.info("Birthday is selected");
		
		//Birthmonth
		WebElement wBirthmonth=IRCTC_Page.drpdwn_BirthMonth();
		Select obBirthmonth= new Select(wBirthmonth);
		obBirthmonth.selectByVisibleText("MAR");
		Utils.printScreenShot(driver, "BirthMonth");
		Log.info("Birthmonth is selected from dropdown by using visible text value");
		logger.log(Status.INFO, "birth month is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"BirthMonth"+".jpg").build());
		Log.info("birth month is selected");
		
		//birthYear
		WebElement wBirthyear= IRCTC_Page.drpdwn_BirthYear();
		Select obBirthyear= new Select(wBirthyear);
		obBirthyear.selectByVisibleText("1998");
		Utils.printScreenShot(driver, "BirthYear");
		Log.info("Birthyear is selected from dropdown by using visible text value ");
		logger.log(Status.INFO, "BirthYear is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"BirthYear"+".jpg").build());
		Log.info("BirthYear is selected");
		
		
		//Occuapation
		WebElement wOccupation=IRCTC_Page.drpdwn_Occupation();
		Select obOccupation= new Select(wOccupation);
		obOccupation.selectByVisibleText("Private");
		Utils.printScreenShot(driver, "Occupation");
		Log.info("occupation is selected as private from dropdown list");
		logger.log(Status.INFO, "occupation is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"Occupation"+".jpg").build());
		Log.info("occupation is selected");
		
		//Adhaar card
		String sAdhaarcard=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_AadharNo);
		Log.info("Aadhar number  from test dta sheet is " +sAdhaarcard);		
		IRCTC_Page.txtbx_Adhaarcard().sendKeys(sAdhaarcard);
		Log.info(sAdhaarcard+ " is entered as addhar number in a text box");	
		Utils.printScreenShot(driver, "AadharNumber");
		logger.log(Status.INFO, "AadharNumber is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"AadharNumber"+".jpg").build());
		Log.info("Aadhar is entered");
		
		//pan card
		String sPancard=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_panCardNo);
		Log.info("pan card nuber from test data sheet is " +sPancard);		
		IRCTC_Page.txtbx_pancard().sendKeys(sPancard);
		Log.info(sPancard+ " is entered as pancard number in a text box");	
		Utils.printScreenShot(driver, "PancardNumber");
		logger.log(Status.INFO, "PancardNumber is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"PancardNumber"+".jpg").build());
		Log.info("pan card number is entered");
		
		//Country
		WebElement wCountry=IRCTC_Page.drpdwn_Country();
		Select obCountry= new Select(wCountry);
		obCountry.selectByVisibleText("India");
		Utils.printScreenShot(driver, "country");
		Log.info("country is selected as india from drop down list");
		logger.log(Status.INFO, "country is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"country"+".jpg").build());
		Log.info("country is selected");
		
		//Email
		String sEmail=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_Email);
		Log.info("email id from test data sheet is " +sEmail);		
		IRCTC_Page.txtbx_email().sendKeys(sEmail);
		Log.info(sEmail+ "is entered as email id in a text box ");
		Utils.printScreenShot(driver, "email");
		logger.log(Status.INFO, "email is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"email"+".jpg").build());
		Log.info("email is entered");
		
		//mobile
		String sMobile=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_mobile);
		Log.info("mobile number from test data sheet is " +sMobile);		
		IRCTC_Page.txtbx_mobile().sendKeys(sMobile);
		Log.info(sMobile+ "is entered as mobile number in a text box");
		Utils.printScreenShot(driver, "mobile");
		logger.log(Status.INFO, "mobile is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"mobile"+".jpg").build());
		Log.info("mobile is entered");
		
		
		//nationality
		WebElement wNationality=IRCTC_Page.drpdwn_nationality();
		Select obNationality= new Select(wNationality);
		obNationality.getOptions();
		obNationality.selectByVisibleText("India");
		Utils.printScreenShot(driver, "nationality");
		Log.info("Nationality is selected as india from drop down list");
		logger.log(Status.INFO, "nationality is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"nationality"+".jpg").build());
		Log.info("nationality is selected");
		
		
		//Flat no
		String sFlat=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_flatno);
		Log.info("flat nummber from test data sheet is " +sFlat);		
		IRCTC_Page.txtbx_flat().sendKeys(sFlat);	
		Log.info(sFlat+ "is entered as flat number in a textbox");
		Utils.printScreenShot(driver, "flat");
		logger.log(Status.INFO, "flat is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"flat"+".jpg").build());
		Log.info("Flat is entered");
		
		//street
		String sStreet=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_street);
		Log.info("street  from test data sheet is " +sStreet);		
		IRCTC_Page.txtbx_street().sendKeys(sStreet);
		Log.info(sStreet+ "is entered as strret in text box");
		Utils.printScreenShot(driver, "street");
		logger.log(Status.INFO, "street is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"street"+".jpg").build());
		Log.info("street is entered");
		
		//Area
		String sArea=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_area);
		Log.info("area from test data sheet is " +sArea);		
		IRCTC_Page.txtbx_area().sendKeys(sArea);
		Log.info(sArea+ "is entered as area in a text box");
		Utils.printScreenShot(driver, "area");
		logger.log(Status.INFO, "area is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"area"+".jpg").build());
		Log.info("area is entered");
		
		//pincode
		String sPincode=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_PinCode);
		Log.info("pin code from test data sheet is " +sPincode);		
		IRCTC_Page.txtbx_pincode().sendKeys(sPincode);
		Log.info(sPincode+ "is entered as  pincode in a textbox");
		Utils.printScreenShot(driver, "pincode");
		logger.log(Status.INFO, "pincode is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"pincode"+".jpg").build());
		Log.info("pincode is entered");
		
		//city
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//select[@name='userRegistrationForm:cityName']")).click();
		IRCTC_Page.drpdwn_city().click();
		Log.info("The city drop down is clicked");
		Thread.sleep(Constant.iThreadWaitShort);
		IRCTC_Page.drpdwn_city().sendKeys(Keys.ARROW_DOWN);
		Log.info("Arrow is moved down on the city name");
		Thread.sleep(Constant.iThreadWaitShort);
		IRCTC_Page.drpdwn_city().sendKeys(Keys.ENTER);
		Utils.printScreenShot(driver, "city");
		Log.info("the city is selected from drop down");
		Thread.sleep(Constant.iThreadWaitShort);
		logger.log(Status.INFO, "city is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"city"+".jpg").build());
		Log.info("city is selected");
		
		//postoffice
		IRCTC_Page.drpdwn_postOffice().click();
		IRCTC_Page.drpdwn_postOffice().sendKeys(Keys.ARROW_DOWN);
		IRCTC_Page.drpdwn_postOffice().sendKeys(Keys.ENTER);
		Utils.printScreenShot(driver, "postOffice");
		Log.info("The post office is selected from drop down");
		logger.log(Status.INFO, "postOffice is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"postOffice"+".jpg").build());
		Log.info("post office is selected");
		
		//phone
		String sPhone=ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_Phonenumber);
		Log.info("phone  from test data sheet is " +sPhone);		
		IRCTC_Page.txtbx_landLine().sendKeys(sPhone);
		Log.info(sPhone+ "is entered as  phone number in a textbox");
		Utils.printScreenShot(driver, "phone");
		logger.log(Status.INFO, "phone is entered", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"phone"+".jpg").build());
		Log.info("phone is entered");
		
		//residence Addresss
		String rResAddr =ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_ResideneoffAddr);
		Log.info("copy of residence address  is selected from test data sheet" +rResAddr);
		if(rResAddr.contains("Yes"))
		{
			IRCTC_Page.rdbtn_coresiYes().click();
			Utils.printScreenShot(driver, "CoYsResiAddr");
			Log.info(" Copy Residence to office Address radio is opted as 'Yes' ");
			logger.log(Status.INFO, "copy Residence to office Address is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"CoYsResiAddr"+".jpg").build());
			Log.info("copy Residence to office Address is selected");
		}else {
			IRCTC_Page.rdbtn_coresiYes().click();
			Utils.printScreenShot(driver, "CoNoResiAddr");
			Log.info(" Copy Residence to office Address radio is opted as No ");
			logger.log(Status.INFO, "copy Residence to office Address is not selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"CoNoResiAddr"+".jpg").build());
			Log.info("copy Residence to office Address is not selected");
		}
				
		
		
		//Newsletter
		String rNewsletter =ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_NewsLetter);
		Log.info("newsletter  is selected from test data sheet " +rNewsletter);
		if  (rNewsletter.contains("Yes"))
		{
			IRCTC_Page.rdbtn_newsltrYes().click();
			Utils.printScreenShot(driver, "newsletterYs");
			Log.info("IRCTC Newsletters radio button is opted as Yes");
			logger.log(Status.INFO, "IRCTC Newsletters radio button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"newsletterYs"+".jpg").build());
			Log.info( "IRCTC Newsletters radio button is selected");
		}else {
			IRCTC_Page.rdbtn_newsltrNo().click();
			Utils.printScreenShot(driver, "newsletterNo");
			Log.info("IRCTC Newsletters radio button is opted as No");
			logger.log(Status.INFO, "IRCTC Newsletters radio button is not selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"newsletterNo"+".jpg").build());
			Log.info( "IRCTC Newsletters radio button is not selected");
		}
		
		
		//Commercial promotion
		
		String rCommercialPromotions =ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_Comercialpromo);
		Log.info("Commercial Promotions is selected from test data sheet" +rCommercialPromotions);
		if(rCommercialPromotions.contains("Yes"))
		{
			IRCTC_Page.rdbtn_commrPromoYes().click();
			Utils.printScreenShot(driver, "ComoPromYes");
			Log.info("Commercial Promotions radion button is optes as Yes");
			logger.log(Status.INFO, "Commercial Promotions radion button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"ComoPromYes"+".jpg").build());
			Log.info("Commercial Promotions radion button is selected");
		}else {
			IRCTC_Page.rdbtn_commrPromoNo().click();
			Utils.printScreenShot(driver, "ComoPromNo");
			Log.info("Commercial Promotions radion button is optes as No");
			logger.log(Status.INFO, "Commercial Promotions radion button is not selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"ComoPromNo"+".jpg").build());
			Log.info("Commercial Promotions radion button is selected");
		}	
		
		
		//PleaseIinformMeAboutIRCTCSBICardThroughPhone 
		String rPleaseIinformMeAboutIRCTCSBICardThroughPhone =ExcelConfig.getCellData(iTestCaseRow,Constant.col_ir_SBicardThruphone);
		Log.info("Please Iinform Me About IRCTC SBI Card Through Phone  is selected from test data sheet" +rPleaseIinformMeAboutIRCTCSBICardThroughPhone);
		if(rPleaseIinformMeAboutIRCTCSBICardThroughPhone.contains("Yes"))
		{
			IRCTC_Page.rdbtn_sbicardthrYes().click();
			Utils.printScreenShot(driver, "sbiCardYes");
			Log.info("Please Iinform Me About IRCTC SBI Card Through Phone radio button is opted as yes");
			logger.log(Status.INFO, "SBI card button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"sbiCardYes"+".jpg").build());
			Log.info("SBI card button is selected");
		}else {
			IRCTC_Page.rdbtn_sbicardthrNo().click();
			Utils.printScreenShot(driver, "sbiCardNo");
			Log.info("Please Iinform Me About IRCTC SBI Card Through Phone radio button is opted as no");
			logger.log(Status.INFO, "SBI card button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"sbiCardNo"+".jpg").build());
			Log.info("SBI card button is not selected");
		}	
		
		
		
		//registrationProcess
		IRCTC_Page.btn_registrationProcess().click();
		Utils.printScreenShot(driver, "registrationProcess");
		Log.info("Registration proccess button is clicked");
		logger.log(Status.INFO, "registrationProcess is clicked", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"registrationProcess"+".jpg").build());
		Log.info("registrationProcess is clicked");
	
		//alert pop up
		WebDriverWait wait=new WebDriverWait(driver, Constant.iExplicitWaitShort);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Log.info("window is pop up with  alert an Ok button is clicked");
		
		
		// Agree button
		wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Log.info("window is pop up with  alert an Ok button is clicked");
		IRCTC_Page.btn_agreeButton().click();
		Utils.printScreenShot(driver, "agreeButton");
		Log.info("Agree button is clicked");
		logger.log(Status.INFO, "Agree button is selected", MediaEntityBuilder.createScreenCaptureFromPath(Constant.screenshotsPath+"agreeButton"+".jpg").build());
		Log.info( "Agree button is selected");
		
		//captacha information
		String sCaptcha= IRCTC_Page.txt_readCaptchaText().getText();
		Log.info("The captcha related  text is read from webpage");
		String text= "Incorrect Captcha. Please Enter Correct captcha.";
		Log.info("the Test case is passed " +text.equalsIgnoreCase(sCaptcha));	
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
