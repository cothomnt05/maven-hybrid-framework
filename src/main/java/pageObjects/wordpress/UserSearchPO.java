package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserSearchPageUI;

public class UserSearchPO extends BasePage {
	WebDriver driver;

	public UserSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNotFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, UserSearchPageUI.NOT_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserSearchPageUI.NOT_FOUND_MESSAGE, message);
	}

}
