package pageObjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	static WebDriver driver;
	@SuppressWarnings("static-access")
	public BaseClass(WebDriver driver) {
		this.driver=driver;
	}

}
