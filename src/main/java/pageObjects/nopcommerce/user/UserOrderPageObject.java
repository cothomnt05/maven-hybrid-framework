package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserOrderPageObject extends BasePage {
	WebDriver driver;

	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
