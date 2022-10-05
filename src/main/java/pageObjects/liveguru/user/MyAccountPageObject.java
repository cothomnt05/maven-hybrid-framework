package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.liveguru.admin.AdminLoginPageObject;
import pageUIs.liveguru.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterSuccessDisplayed() {
		return isElementDisplayed(driver, MyAccountPageUI.REGISTER_SUCCESS_MESSAGE);

	}

	public boolean isMyAccountPageDisplayed() {
		return isElementDisplayed(driver, MyAccountPageUI.MY_ACCOUNT_PAGE_HEADER);
	}

	public AdminLoginPageObject openAdminPage() {
		openPageUrl(driver, "http://live.techpanda.org/index.php/backendlogin");
		return PageGeneratorManager.getAdminLoginPageObject(driver);
	}
}
