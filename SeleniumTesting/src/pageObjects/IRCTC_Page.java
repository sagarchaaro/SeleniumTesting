package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Log;

public class IRCTC_Page extends BaseClass {
	

	public static WebElement element;
	public IRCTC_Page(WebDriver driver) {
		super(driver);
	
	}
	
	public static WebElement txtbx_UserId()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:userName"));
			Log.info("User id text-box is found on IRCTC Registration page");
		}catch(Exception e) {
		Log.info("User id text-box is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
		}
	public static WebElement lnk_chkAvail()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.linkText("Check Availability"));
			Log.info("User id text-box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("User id text-box is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_password()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:password"));
			Log.info("Password text-box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Password text-box is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_Confrmpassword()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:confpasword"));
			Log.info("Confirm password text-box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Confirm password text-box is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_securityquestion()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.id("userRegistrationForm:securityQ"));
			Log.info("securityquestion dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("securityquestion dropdown is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_SceurityAnswer()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:securityAnswer"));
			Log.info("sceurityAnswer text-box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("SceurityAnswer  text box is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_PlLanguage()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:prelan"));
			Log.info("PlLanguage dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("PlLanguage dropdown is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Firstname()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:firstName"));
			Log.info("First name text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("First name text box  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Middlename()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:middleName"));
			Log.info("Middle name text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Middle name text box  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Lastname()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:lastName"));
			Log.info("Last name text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Last name text box  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_genderfem()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//label[text()=' Female']"));
			Log.info("Gender female radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Gender female radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_genderMale()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//label[text()='Male']"));
			Log.info("Gender male radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Gender male radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_married()  throws Exception{
		element=null;
		try {
			element =driver.findElement(By.xpath("//label[text()=' Married']"));
			Log.info("Married radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Married radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_Unmarried()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//label[text()='  Unmarried']"));
			Log.info("Unmarried radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Unmarried radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_birthday()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:dobDay"));
			Log.info("Birthday dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Birthday dropdown is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_BirthMonth()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:dobMonth"));
			Log.info("Birthmonth dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Birthmonth dropdown  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_BirthYear()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:dateOfBirth"));
			Log.info("Birthyear dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Birthyear dropdown  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_Occupation()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:occupation"));
			Log.info("Occupation dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Occupation dropdown  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_Adhaarcard()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:uidno"));
			Log.info("Adhaarcard text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Adhaarcard textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}

	public static WebElement txtbx_pancard()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:idno"));
			Log.info("pancard text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("pancard textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_Country()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:countries"));
			Log.info("Country dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Country dropdown  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_email()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:email"));
			Log.info("email text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("email textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	

	public static WebElement txtbx_mobile()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:mobile"));
			Log.info("mobile text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("mobile textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_nationality()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:nationalityId"));
			Log.info("nationality dropdown is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("nationality dropdown  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}	
	public static WebElement txtbx_flat()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:address"));
			Log.info("flattext box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("flat textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_street()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:street"));
			Log.info("street text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("street textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_area()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:area"));
			Log.info("area text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("area textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_pincode()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:pincode"));
			Log.info("pincode text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("pincode textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_city()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//select[@name='userRegistrationForm:cityName']"));
			Log.info("City drop down is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("City drop down is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement drpdwn_postOffice()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//select[@name='userRegistrationForm:postofficeName']"));
			Log.info("Post office drop down is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Post office drop down is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_landLine()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.name("userRegistrationForm:landline"));
			Log.info("landline text box is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("landline textbox  is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_coresiYes()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:resAndOff:0']"));
			Log.info("Copy of residence Yes radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Copy of residence Yes button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_coresiNo()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:resAndOff:1']"));
			Log.info("Copy of residence No radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Copy of residence No radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_newsltrYes()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:newsletter:0']"));
			Log.info("News letter Yes radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("News letter Yes radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_newsltrNo()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:newsletter:1']"));
			Log.info("News letter No radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("News letter No radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_commrPromoYes()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:commercialpromo:0']"));
			Log.info("Comercial promotion Yes radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Comercial promotion Yes radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_commrPromoNo()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:commercialpromo:1']"));
			Log.info("Comercial promotion No radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Comercial promotion No radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_sbicardthrYes()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:irctcsbicard:0']"));
			Log.info("inform me about IRCTC SBI Card through phone Yes radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("inform me about IRCTC SBI Card through phone Yes radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement rdbtn_sbicardthrNo()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@id='userRegistrationForm:irctcsbicard:1']"));
			Log.info("inform me about IRCTC SBI Card through phone No radio button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("inform me about IRCTC SBI Card through phone No radio button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_registrationProcess()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//a[@name='userRegistrationForm:j_idt502']"));
			Log.info("Registration porcess submit button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Registration porcess submit button is is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement btn_agreeButton()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//input[@name='userRegistrationForm:saveBtnIe']"));
			Log.info("I Agree button is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("I Agree button is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
	public static WebElement txt_readCaptchaText()  throws Exception{
		element=null;
		try {
			element=driver.findElement(By.xpath("//span[text()='Incorrect Captcha. Please  Enter Correct captcha.']"));
			Log.info("Captcha text is found on IRCTC Registration page");
		}catch(Exception e) {
			Log.info("Captch text is not found on IRCTC Registration page");
			throw(e);
		}
		return element;
	}
}