package pageObjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	static WebDriver driver;
	public BaseClass(WebDriver driver) {
		this.driver=driver;
	}

}
