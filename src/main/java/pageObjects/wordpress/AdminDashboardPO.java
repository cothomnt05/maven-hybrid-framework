package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenu() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU);
		return PageGeneratorManager.getAdminPostSearchPageObject(driver);

	}
}
