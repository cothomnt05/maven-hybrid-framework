package pageObjects.saucedemo;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ProductPageObject getProductPageObject(WebDriver driver) {
		return new ProductPageObject(driver);
	}

}
