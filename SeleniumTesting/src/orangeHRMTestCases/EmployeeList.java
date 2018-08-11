package orangeHRMTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.BaseClass;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.Utils;

public class EmployeeList {
	static WebDriver driver;
	
	public static void main(String args[]) throws Exception {
		
		int iTestCaseRow=ExcelConfig.getRow(Constant.logintestDataPath, Constant.Sheet_Orange);
		System.out.println("Matched Test Row is: "+iTestCaseRow);
		driver=Utils.openBrowser();
		System.out.println("Browser is Launched");
		new BaseClass(driver);
		System.out.println("driver instance is passed to BaseClass driver");
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println("Oragane HRM page is launched");
		String sUserid =ExcelConfig.getCellData(iTestCaseRow,Constant.col_or_userid);
		System.out.println("UserID from Test Data sheet is: " +sUserid);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(sUserid);
		System.out.println(sUserid+ " is enetered as a UserID in a text-box");
		String sPassword =ExcelConfig.getCellData(iTestCaseRow,Constant.col_or_password);
		System.out.println("password from Test Data sheet is: " +sPassword);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(sPassword);
		System.out.println(sPassword+ " is enetered as a Password in a text-box");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		System.out.println(" login button is clicked");
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		System.out.println(" PIM module is clicked");
		Actions action = new Actions(driver);
		WebElement employeeList=driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
		action.moveToElement(employeeList).perform();
		System.out.println(" cursor is moved to employee list");
		int rowCount=driver.findElements(By.xpath("*//table[@id='resultTable']/tbody/tr")).size();
		System.out.println("The Number of rows: "+rowCount);
		int colCount=driver.findElements(By.xpath("*//table[@id='resultTable']/tbody/tr[1]/td")).size();
		System.out.println("The Number of columns: "+colCount);
		System.out.println("Printing complete whole webtable data");
		for(int row=1;row<=rowCount;row++) {
			for(int col=1;col<=colCount;col++) {
				String s=driver.findElement(By.xpath("*//table[@id='resultTable']/tbody/tr["+row+"]/td["+col+"]")).getText();
				System.out.print(s);
				System.out.print("         ");
			}
			System.out.println();
		}
		Thread.sleep(Constant.iThreadWait);
		//WebDriverWait wait=new WebDriverWait(driver, Constant.iExplicitWaitShort);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='panelContainer']")))).click();
		driver.findElement(By.xpath("//a[@class='panelTrigger']")).click();
		System.out.println("The welcome panel/window is clicked ");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("The logout button is clicked");
		driver.quit();
		}
	}


