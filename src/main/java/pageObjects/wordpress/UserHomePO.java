package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);

	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);

	}

	public boolean isPostInforDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);

	}

	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);

	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPageObject(driver);
	}

	public boolean isPostTitleUndisplayed(String postTitle) {
		waitForElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.POST_SEARCH_TEXTBOX, postTitle);
	}

	public UserSearchPO clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.POST_SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.POST_SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPageObject(driver);
	}

}
