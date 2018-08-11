package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Log;

public class FB_Page extends BaseClass{
	
	public static WebElement element;
	
	public FB_Page(WebDriver driver) {
		super(driver);
	
	}
	public static WebElement txtbx_FirstName()  throws Exception{
	element=null;
	try {
		element=driver.findElement(By.name("firstname"));
		Log.info("FirstName text-box is found on FaceBook Registration page");
		}catch(Exception e) {
		Log.info("FirstName text-box is not found on FaceBook Registration page");
		throw(e);
		}
		return element;
	}
		
		public static WebElement txtbx_LastName() throws Exception{
			element=null;
			try {
				element=driver.findElement(By.name("lastname"));
				Log.info("Last name text-box is found on FaceBook Registration page");
			}catch(Exception e) {
				Log.info("LastName text-box is not found on FaceBook Registration page");
				throw(e);
			}
			return element;
		}
	public static WebElement txbx_mobileEmailAddr() throws Exception {
			element=null;
			try {
				element=driver.findElement(By.name("reg_email__"));
				Log.info("Email Address/mobile text-box is found on FaceBook Registration page");
				
			}catch(Exception e) {
				Log.info("LastName text-box is not found on FaceBook Registration page");
				throw(e);
			}
			return element;
		}
	public static WebElement txbx_createPassword() throws Exception {
		element=null;
		try {
			element=driver.findElement(By.name("reg_passwd__"));
			Log.info("create Password text-box is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("create Password text-box is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}	
	public static WebElement drpdwn_BirthDate() throws Exception {
		element=null;
		try {
			element=driver.findElement(By.name("birthday_day"));
			Log.info("Birth date drop down is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Birth date drop down is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}	
	public static WebElement drpdwn_BirthMonth () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.name("birthday_month"));
			Log.info("Birth month drop down is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Birth month drop down is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}	
	public static WebElement drpdwn_BirthYear () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.name("birthday_year"));
			Log.info("Birth year drop down is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Birth year drop down is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}	
	public static WebElement rdbtn_genderFem () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.xpath("//label[text()='Female']"));
			Log.info("Female radio button is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Female radio button is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}	
	public static WebElement rdbtn_genderMale () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.xpath("//label[text()='Male']"));
			Log.info("Male radio button is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Male radio button is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}
	public static WebElement btn_createAccount () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.xpath("//div/button[@name='websubmit']"));
			Log.info("Create Account button is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Create Account button is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}
	public static WebElement txbx_smsCode () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='code_in_cliff']"));
			Log.info("SMS alert code text box is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("SMS alert code text box is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}
	public static WebElement btn_continue () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.xpath("//button[text()='Continue']"));
			Log.info("Continue button is found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Continue button is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}
	public static WebElement msg_txt () throws Exception {
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='code_in_cliff']"));
			Log.info("Text message element found on FaceBook Registration page");
			
		}catch(Exception e) {
			Log.info("Text message element is not found on FaceBook Registration page");
			throw(e);
		}
		return element;
		}
	}


