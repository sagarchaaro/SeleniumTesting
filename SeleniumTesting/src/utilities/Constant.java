package utilities;

public class Constant  {
	
	//Registration sheet Test Cases
	public static String sheet_Gmail="Gmail";
	public static String sheet_Fb="Facebook";
	public static String Sheet_naukiri= "Naukiri";
	public static String Sheet_IRCTC= "IRCTC";
	public static String Sheet_Orange= "Orange";
	
	public static String sheet_GmailLogin="GmailLogin";
	public static String Test_Id="G001";
	//public static String col_Browser="Firefox";
	public static int	col_TestId=0;
	static String filePath=System.getProperty("user.dir");
	public static String screenshotsPath=filePath+"\\Screenshots\\";
	public static String extentReportsPath=filePath+"\\ExtentReports\\";
	public static String chromeDriverPath=filePath+"\\Drivers\\Chrome\\chromedriver.exe";
	public static String fireFoxDriverPath=filePath+"\\Drivers\\Firefox\\geckodriver.exe";
	public static String ieDriverPath=filePath+"\\Drivers\\IE\\IEDriverServer.exe";
	public static String operaDriverPath=filePath+"\\Drivers\\Opera\\operadriver_win64\\operadriver.exe";
	public static String registrationstestDataPath=filePath+"\\TestData\\Registration.xlsx";
	public static String logintestDataPath=filePath+"\\TestData\\Login.xlsx";
	public static String tngSuitePath=filePath+"\\TestResults\\";
	
	
	//TimeOuts
	public static final int iThreadWaitShort=2000;
	public static final int iThreadWait=5000;
	public static final int iThreadWaitLarge=8000;
	public static final int iThreadWaitLargeLarge=12000;
	public static final int iImplicitWaitShort=5;
	public static final int iImplicitWait=10;
	public static final int iExplicitWaitShort=10;
	public static final int iExplicitWait=20;
	public static final int iExplicitWaitLarge=40;
	
	//Gmail columns
	public static int col_Gmail_FirstName=1;
	public static int col_Gmail_LastName=2;
	public static int col_gmail_UserName=3;
	public static int col_Gmail_createPassword=4;
	public static int col_Gmail_confirmPassword=5;
	public static int col_Gmail_mobile=6;
	public static int col_Gmail_month=6;
	public static int col_Gmail_date=7;
	public static int col_Gmail_year=8;
	public static int col_Gmail_gender=9;
	public static int col_Gmail_currentEmail=11;
	public static int col_Gmail_country=12;
	//facebook columns
	public static int col_fb_FirstName=1;
	public static int col_fb_Surname=2;
	public static int col_fb_Mobilemailaddress=3;
	public static int col_fb_Newpassword=4;
	public static int col_fb_date=5;
	public static int col_fb_month=6;
	public static int col_fb_year=7; 
	public static int col_fb_gender=8;
	public static int col_fb_smsCode=9;
	
	//naukiri columns
	public static int col_na_Name=1;
	public static int col_na_Email=2;
	public static int col_na_CreatePassword=3;
	public static int col_na_mobile=4;
	public static int col_na_currentLocation=5;
	public static int col_na_resume=6;
	public static int col_na_Highest_Qualification=7;
	public static int col_na_course=8;
	public static int col_na_Specialization=9;
	public static int col_na_college=10;
	public static int col_na_course_type=11;
	public static int col_na_passin_year=12;
	public static int col_na_skills=13;
	//IRCTC coloumns
	public static int col_ir_userid=1;
	public static int col_ir_password=2;
	public static int col_ir_confirmpassword=3;
	public static int col_ir_SecurityQuestion=4;
	public static int col_ir_SecurityAnswer=5;
	public static int col_ir_peferredLanguage=6;
	public static int col_ir_FirstName=7;
	public static int col_ir_MiddleName=8;
	public static int col_ir_LasttName=9;
	public static int col_ir_gender=10;
	public static int col_ir_maritalStatus=11;
	public static int col_ir_day=12;
	public static int col_ir_month=13;
	public static int col_ir_year=14;
	public static int col_ir_Occupation=15;
	public static int col_ir_AadharNo=16;
	public static int col_ir_panCardNo=17;
	public static int col_ir_Country=18;
	public static int col_ir_Email=19;
	public static int col_ir_mobile=20;
	public static int col_ir_nationality=21;
	public static int col_ir_flatno=22;
	public static int col_ir_street=23;
	public static int col_ir_area=24;
	public static int col_ir_PinCode=25;
	public static int col_ir_City=26;
	public static int col_ir_POS=27;
	public static int col_ir_Phonenumber=28;
	public static int col_ir_ResideneoffAddr=29;
	public static int col_ir_NewsLetter=30;
	public static int col_ir_Comercialpromo=31;
	public static int col_ir_SBicardThruphone=32;
	//Orange columns
	public static int col_or_userid=1;
	public static int col_or_password=2;
}
