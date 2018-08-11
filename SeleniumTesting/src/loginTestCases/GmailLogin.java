package loginTestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.BaseClass;
import pageObjects.Gmail_Page;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.ExtentManager;
import utilities.Log;
import utilities.Utils;

public class GmailLogin {
	
	static WebDriver driver;
	static String testname;
	static ExtentReports report;
	static ExtentTest logger;
	static Logger log4j;
	
	@DataProvider(name="gmailLoginData")
	public static Object[][] readExcel(){
		
		Object[][] data=new Object[10][2];
		data[0][0]=ExcelConfig.getCellData(0, 1);//First Row UserName
		data[0][1]=ExcelConfig.getCellData(0, 2);
		
		data[1][0]=ExcelConfig.getCellData(1, 1);
		data[1][1]=ExcelConfig.getCellData(1, 2);

		data[2][0]=ExcelConfig.getCellData(2, 1);
		data[2][1]=ExcelConfig.getCellData(2, 2);

		data[3][0]=ExcelConfig.getCellData(3, 1);
		data[3][1]=ExcelConfig.getCellData(3, 2);
		
		/*for(r=0;r<=10;r++)
		{
			for(c=0;c<=2;c++)
			{
				data[r][c]=ExcelConfig.getCellData(r,(c+1));
			}
			
		}*/
		return data;			
	}
	
	@BeforeClass
	public static void startWebDriver() throws Exception{
		testname=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1);
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.xml");		
		report=ExtentManager.createInstance(testname);
		Log.startTestCase("Gmail Login");
		
		ExcelConfig.setExcelPath(Constant.logintestDataPath, Constant.sheet_GmailLogin);
		driver=Utils.openBrowser();
		Log.info("Browser Launched");
		new BaseClass(driver);
		
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="gmailLoginData")
	public static void loginTest(String sUserName, String sPassword) throws Exception{
		try {
			
			//driver.get("http://www.gmail.com");
			//driver.manage().window().maximize();
			
			Gmail_Page.lnk_UseAnotherAccount().click();
			Log.info("User Another Account Link is clicked");
			
			Gmail_Page.txtbx_UserName().clear();
			Gmail_Page.txtbx_UserName().sendKeys(sUserName);
			Log.info(sUserName+" is entered as UserName in text-box");
	
			
			Gmail_Page.btn_LoginNext().click();
			Log.info("click action is performed on Next button");
			
			Gmail_Page.txbx_LoginPaswd().clear();
			Gmail_Page.txbx_LoginPaswd().sendKeys(sPassword);;
			Log.info(sPassword+" is entered as password in text-box");
	
			
			Gmail_Page.btn_PaswdNext().click();
			Log.info("click action is performed on Next button");
			
			Gmail_Page.lnk_googleAccnt().click();
			Log.info("Google account is linked");
			
			String sExpectedTitle="Google Account";
			
			String sAccntInfo=Gmail_Page.msg_googleAccount().getText();
			
			SoftAssert ob=new SoftAssert();
			ob.assertEquals(sAccntInfo, sExpectedTitle,"Both values are not matched");
			
			Gmail_Page.btn_loginSignOut().click();
			Log.info("Sign out button is clicked");
			
		}catch(Exception e) {	
			
			// driver.get("https://www.google.com/gmail/about/#");
			
			Gmail_Page.lnk_loginSignIn().click();
			Log.info("click action is performed on Sign in button");
			
			Gmail_Page.txtbx_UserName().clear();
			Gmail_Page.txtbx_UserName().sendKeys(sUserName);
			Log.info(sUserName+" is entered as UserName in text-box");
			
			
			Gmail_Page.btn_LoginNext().click();
			Log.info("click action is performed on Next button");
			
			Gmail_Page.txbx_LoginPaswd().clear();
			Gmail_Page.txbx_LoginPaswd().sendKeys(sPassword);;
			Log.info(sPassword+" is entered as password in text-box");
			
			
			Gmail_Page.btn_PaswdNext().click();
			Log.info("click action is performed on Next button");
			
			Gmail_Page.lnk_googleAccnt().click();
			Log.info("Google account is linked");
			
			String sExpectedTitle="Google Account";
			
			String sAccntInfo=Gmail_Page.msg_googleAccount().getText();
			
			SoftAssert ob=new SoftAssert();
			ob.assertEquals(sAccntInfo, sExpectedTitle,"Both values are not matched");
			
			Gmail_Page.btn_loginSignOut().click();
			Log.info("Sign out button is clicked");
		
		
		}
		

	}
}
