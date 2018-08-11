package login.com.orangehemlive.demo.opensource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {
	public static void main(String args[]) {
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		
		WebDriver driver=new ChromeDriver(dc);
	}
}
