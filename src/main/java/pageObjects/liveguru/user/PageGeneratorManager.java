package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import pageObjects.liveguru.admin.AdminLoginPageObject;
import pageObjects.liveguru.admin.AdminManagerCustomerPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getHomePageObject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminManagerCustomerPageObject getManagerCustomerPageObject(WebDriver driver) {
		return new AdminManagerCustomerPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
}
