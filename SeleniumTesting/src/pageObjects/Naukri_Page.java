package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Log;

public class Naukri_Page extends BaseClass{
	
	public static WebElement element;
	
	public Naukri_Page (WebDriver driver) {
		super(driver);
	}
	
	public static WebElement lnk_IamFresher()  throws Exception{
		element=null;
		try {
			element= driver.findElement(By.xpath("//button[text()='I am a Fresher']"));
			Log.info("I am freaher link is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("I am freaher link is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_FirstName()  throws Exception{
		element=null;
		try {
			element= driver.findElement(By.name("fname"));
			Log.info("FirstName text-box is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("FirstName text-box is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_email()  throws Exception{
		element=null;
		try {
			element= driver.findElement(By.name("email"));
			Log.info("email text-box is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("email text-box is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_createPassword()  throws Exception{
		element=null;
		try {
			element= driver.findElement(By.name("password"));
			Log.info("Create Password text-box is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("Create Password text-box is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_mobile()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("number"));
			Log.info("mobile number text-box is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("mobile number text-box is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_currlocArrow()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//span[@class='ddIcon srchTxt']"));
			Log.info("current location dropdown Arrow click is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("current location dropdown Arrow click is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_currlocation()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("(//input[@name='city'])[1]"));
			Log.info("current location dropdown is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("current location dropdown is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement lnk_CopyResume()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//a[text()='copy-paste your resume here']"));
			Log.info("copy-paste your resume here link is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("copy-paste your resume here link is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_PasteResume()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("textCV"));
			Log.info("Resume paste text box is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("Resume paste text box is is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_RegisterNow()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//button[text()='Register Now']"));
			Log.info("Register now button is found on Naukri Registration page");
		}catch(Exception e) {
			Log.info("Register now button is not found on Naukri Registration page");
			throw(e);
		}
		return element;
	}
}
