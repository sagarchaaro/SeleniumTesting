package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Log;

public class Gmail_Page extends BaseClass {
	
	public static WebElement element;
	
	public Gmail_Page(WebDriver driver) {
		super(driver);
		}
	public static WebElement txtbx_FirstName()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("firstName"));
			Log.info("FirstName text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("FirstName text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_LastName()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("lastName"));
			Log.info("LastName text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("LastName text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_userName()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("username"));
			Log.info("username text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("username text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_CreatePasswd()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("(//input[@name='Passwd'])[1]"));
			Log.info("Create password text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Create password  text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_ConfmPasswd()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("(//input[@name='ConfirmPasswd'])[1]"));
			Log.info("Confirm password text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Confirm password  text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_next()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//span[text()='Next']"));
			Log.info("next button is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info(" next button is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_mobileNumber()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("phoneNumberId"));
			Log.info("Mobile number text box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Mobile Number textbox is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_secondNext()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//span[text()='Next']"));
			Log.info("next button is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info(" next button is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_Birthmonth()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//div[@title='Birthday']"));
			Log.info("Birthmonth dropdown is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Birthmonth dropdown is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_BirthDate()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("BirthDay"));
			Log.info("Birth day text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Birthday text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_BirthYear()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("BirthYear"));
			Log.info("Birth year text-box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Birthyear text-box is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_Gender()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//div[@title='Gender']"));
			Log.info("Gender drop down is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Gender drop down is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_MobNumber()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("RecoveryPhoneNumber"));
			Log.info("Mobile number text box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Mobile Number textbox is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_CurrEmailAddr()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("RecoveryEmailAddress"));
			Log.info("Current email address text box is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Current email address textbox is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_locationArrw()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//div[@id='CountryCode']/div/div[2]"));
			Log.info("Location drop down arrow is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Location drop down arrow is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_Next()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='submitbutton']"));
			Log.info("next button is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("next button is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_Agree()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("*//input[@id='iagreebutton']"));
			Log.info("Agree button is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Agree button is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_Continue()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='next-button']"));
			Log.info("Continue button is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Continue button is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement msg_readtxt()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='next-button']"));
			Log.info("Continue button is found on Gmail Registration page");
		}catch(Exception e) {
			Log.info("Continue button is not found on Gmail Registration page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement lnk_UseAnotherAccount() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("*//div[@id='identifierLink']/div[2]/p"));
			Log.info("Use Another Account link is found on Gmail page");
		}catch(Exception e) {
			Log.error("Use Another Account link is not found on Gmail page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_UserName() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("*//input[@id='identifierId']"));
			Log.info("UserName text-box is found on Gmail page");
		}catch(Exception e) {
			Log.error("UserName text-box is found on Gmail page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement btn_LoginNext() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("*//div[@id='identifierNext']/content/span"));
			Log.info("Next button is found on Gmail page");
		}catch(Exception e) {
			Log.error("Next button is not found on Gmail page");
			throw(e);
		}
		return element;
	}
	public static WebElement txbx_LoginPaswd() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@name='password']"));
			Log.info("Password text is found on Gmail page");
		}catch(Exception e) {
			Log.error("Password text is not found on Gmail page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_PaswdNext() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//span[text()='Next']"));
			Log.info("Next button is found on Gmail page");
		}catch(Exception e) {
			Log.error("Next button is not found on Gmail page");
			throw(e);
		}
		return element;
	}
	public static WebElement lnk_googleAccnt() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//span[@class='gb_db gbii']"));
			Log.info("Google account link is found on Gmail page");
		}catch(Exception e) {
			Log.error("Google account link is not found on Gmail page");
			throw(e);
		}
		return element;
		
	}
	public static WebElement msg_googleAccount() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//a[text()='Google Account']"));
			Log.info("Google account message is found on Gmail page");
		}catch(Exception e) {
			Log.error("Google account message is not found on Gmail page");
			throw(e);
		}
		return element;
		
	}
	public static WebElement btn_loginSignOut() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//a[text()='Sign out']"));
			Log.info("Sign out is found on Gmail page");
		}catch(Exception e) {
			Log.error("Sign out is not found on Gmail page");
			throw(e);
		}
		return element;
		
	}
	public static WebElement lnk_loginSignIn() throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//a[text()='Sign In']"));
			Log.info("Sign In is found on Gmail page");
		}catch(Exception e) {
			Log.error("Sign In is not found on Gmail page");
			throw(e);
		}
		return element;
		
	}
	
}
