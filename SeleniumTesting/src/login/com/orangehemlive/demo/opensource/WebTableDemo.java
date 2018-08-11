package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\Learning\\Html\\getXpathCountandVerifyTable.html");
		driver.manage().window().maximize();
		
		int rowCount=driver.findElements(By.xpath("*//table[@id='idCourse']/tbody/tr")).size();
		System.out.println("The Number of rows: "+rowCount);
		
		int colCount=driver.findElements(By.xpath("*//table[@id='idCourse']/tbody/tr[1]/td")).size();
		System.out.println("The Number of columns: "+colCount);
		
		int totalCount=driver.findElements(By.xpath("*//table[@id='idCourse']/tbody/tr/td")).size();
		System.out.println("The Total number of cells: "+totalCount);
		
		String courseName=driver.findElement(By.xpath("*//table[@id='idCourse']/tbody/tr[4]/td[2]")).getText();
		System.out.println("Course Name at 4th row and 2nd column is: "+courseName);
		
		System.out.println("Printing complete 5th row data");
		for(int i=1;i<=colCount;i++) {
			String s=driver.findElement(By.xpath("*//table[@id='idCourse']/tbody/tr[4]/td["+i+"]")).getText();
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("Printing complete 2nd column data");
		for(int i=1;i<=rowCount;i++) {
			String s=driver.findElement(By.xpath("*//table[@id='idCourse']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(s);
		}
		
		System.out.println("Printing complete whole webtable data");
		for(int row=1;row<=rowCount;row++) {
			for(int col=1;col<=colCount;col++) {
				String s=driver.findElement(By.xpath("*//table[@id='idCourse']/tbody/tr["+row+"]/td["+col+"]")).getText();
				System.out.print(s);
				System.out.print("         ");
			}
			System.out.println();
		}
		
	}
}
