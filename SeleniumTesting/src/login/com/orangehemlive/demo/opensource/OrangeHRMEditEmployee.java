package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRMEditEmployee {
	public static void main(String args[]) {
		try{
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Jars and Drivers\\Drivers\\Chrome\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.navigate().to("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
			Thread.sleep(4000);
			driver.manage().window().maximize();
			System.out.println("Browser is maximized");
			
			
			//UserName
			String tag=driver.findElement(By.id("txtUsername")).getTagName();
			System.out.println("The current tag name is: "+tag);
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			System.out.println("UserName is entered");
			
			//Password
			driver.findElement(By.name("txtPassword")).sendKeys("admin");
			System.out.println("Password is entered");			
			
			//Login button
			String attr=driver.findElement(By.name("Submit")).getAttribute("id");
			System.out.println("Attribute value is: "+attr);
			driver.findElement(By.name("Submit")).click();
			System.out.println("Login button is clicked");
			
			Actions action=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("*//b[text()='PIM']"));
			action.moveToElement(ele).build().perform();
			Thread.sleep(1000);
			System.out.println("Mousehover on PIM menu");
			
			driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
			System.out.println("EmployeeList link is clicked");
			
			int rowSize=driver.findElements(By.xpath("*//table[@id='resultTable']/tbody/tr")).size();
			for(int i=1;i<=rowSize;i++) {
				String id=driver.findElement(By.xpath("*//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a")).getText();
				if(id.equalsIgnoreCase("0004")) {
					driver.findElement(By.xpath("*//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a")).click();
					System.out.println("Matched WebElement is found and it is clicked");
					Thread.sleep(3000);
					break;
				}
			}
			
			//Edit button
			Dimension btnSize=driver.findElement(By.xpath("*//input[@id='btnSave']")).getSize();
			int height=btnSize.height;
			int width=btnSize.width;
			System.out.println("Height is: "+height +"width is: "+width);
			driver.findElement(By.xpath("*//input[@id='btnSave']")).click();
			System.out.println("Edit button is Clicked");
			
			//FirstName
			driver.findElement(By.id("personal_txtEmpFirstName")).clear();
			System.out.println("FirstName data is cleared");
			Thread.sleep(1000);
			driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Sagar");
			
			//MiddleName
			driver.findElement(By.id("personal_txtEmpMiddleName")).sendKeys("CH");
			
			//LastName
			WebElement LastNameElement=driver.findElement(By.id("personal_txtEmpLastName"));
			boolean LastName=LastNameElement.isEnabled();
			if(LastName) {
				System.out.println("LastName element is enabled");
				LastNameElement.clear();
				System.out.println("Last Name value is cleared");
				Thread.sleep(1000);
				LastNameElement.sendKeys("Chakilala");
			}else {
				System.out.println("LastName element is not enabled");
			}
			
			//Nationality
			WebElement Nationality=driver.findElement(By.id("personal_cmbNation"));
			Select s=new Select(Nationality);
			s.selectByIndex(10);
			System.out.println("The 10th position value is selected");
			Thread.sleep(3000);
			s.selectByVisibleText("Indian");
			System.out.println("The Indian value is selected");
			Thread.sleep(3000);
			s.selectByValue("5");
			System.out.println("The 5th value is selected");
			Thread.sleep(3000);
			
			
			
			//Gender
			boolean Gender=driver.findElement(By.id("personal_optGender_1")).isSelected();
			if(Gender) {
				System.out.println("Gender is already selected with Male value");
			}else {
				System.out.println("Gender is not already selected with Male value");
			}			
			
			//Save button
			WebElement saveWebElement=driver.findElement(By.id("btnSave"));
			Point savePoint=saveWebElement.getLocation();
			int savePointX=savePoint.getX();
			int savePointY=savePoint.getY();
			System.out.println("X coordinate value is: "+savePointX+"Y coordinate value is: "+savePointY);
			
			String savebtncolor=saveWebElement.getCssValue("color");
			System.out.println("Save button color is: "+savebtncolor);
			String fontsize=saveWebElement.getCssValue("font-size");
			System.out.println("Save button font-size is"+fontsize );
			
			boolean saveDisplay=saveWebElement.isDisplayed();
			if(saveDisplay) {
				System.out.println("Save button is displayed");
				saveWebElement.click();
			}else {
				System.out.println("Save button is not displayed");
			}
			
			
			
		}catch(InterruptedException ie) {
			System.err.println("Interrupted Exception Occurred" +ie.getMessage());
		}
		
	}
}
