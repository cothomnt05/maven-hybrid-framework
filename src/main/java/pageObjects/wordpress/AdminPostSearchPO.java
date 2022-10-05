package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrlPostSearchPage() {
		return getPageCurrentUrl(driver);

	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPageObject(driver);

	}

	public void enterToSearchPostTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX, postTitle);

	}

	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);

	}

	public boolean isPostSearchTableDisplay(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

	public AdminPostAddNewPO clickToPostTitleLink(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		clickToElement(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return PageGeneratorManager.getAdminPostAddNewPageObject(driver);
	}

	public void selectPostDetailCheckbox(String editTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.CHECKBOX_POST_BY_POST_TITLE, editTitle);
		checkToDefaultCheckboxRadio(driver, AdminPostSearchPageUI.CHECKBOX_POST_BY_POST_TITLE, editTitle);
	}

	public void selectActionInDropdown(String expectedvalue) {
		waitForElementVisible(driver, AdminPostSearchPageUI.ACTIONS_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTIONS_DROPDOWN, expectedvalue);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_ACTION_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_ACTION_BUTTON);
	}

	public boolean isdeletedMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.DELETED_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.DELETED_MESSAGE, message);
	}

	public boolean isNotFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NOT_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NOT_POST_FOUND_MESSAGE, message);
	}

}
