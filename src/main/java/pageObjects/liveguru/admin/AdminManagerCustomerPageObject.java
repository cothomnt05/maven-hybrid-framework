package pageObjects.liveguru.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageObjects.liveguru.user.PageGeneratorManager;
import pageObjects.liveguru.user.UserHomePageObject;
import pageUIs.liveguru.ManagerCustomerPageUI;

public class AdminManagerCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminManagerCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToIconClosePopup() {
		waitForElementClickable(driver, ManagerCustomerPageUI.CLOSE_ICON_POPUP);
		clickToElement(driver, ManagerCustomerPageUI.CLOSE_ICON_POPUP);
	}

	public boolean isPopupDisplayed() {
		return isElementDisplayed(driver, ManagerCustomerPageUI.POPUP);
	}

	public void enterToHeaderTextboxByLabel(String columnName, String value) {
		int columnIndex = getElementSize(driver, ManagerCustomerPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, ManagerCustomerPageUI.FILTER_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		sendkeyToElement(driver, ManagerCustomerPageUI.FILTER_BY_COLUMN_INDEX, value, String.valueOf(columnIndex));
		pressKeyToElement(driver, ManagerCustomerPageUI.FILTER_BY_COLUMN_INDEX, Keys.ENTER, String.valueOf(columnIndex));

	}

	public String getTextFromTextboxByColumnNameAtRowNumber(String columnName) {
		int columnIndex = getElementSize(driver, ManagerCustomerPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, ManagerCustomerPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, String.valueOf(columnIndex));
		return getElementText(driver, ManagerCustomerPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, String.valueOf(columnIndex));
	}

	public void checkToCheckboxField() {
		waitForElementClickable(driver, ManagerCustomerPageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX);
		if (!isElementSelected(driver, ManagerCustomerPageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX)) {
			clickToElementByJS(driver, ManagerCustomerPageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX);
		}
	}

	public void selectActions(String expectedAction) {

		WebElement element = getWebElement(driver, ManagerCustomerPageUI.ACTIONS_DROPDOWN);
		((JavascriptExecutor) driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", element, expectedAction);
	}

	public void clickToActionSubmitButton() {
		waitForElementClickable(driver, ManagerCustomerPageUI.ACTION_SUBMIT_BUTTON);
		clickToElementByJS(driver, ManagerCustomerPageUI.ACTION_SUBMIT_BUTTON);
	}

	public void handleAlert() {
		acceptAlert(driver);

	}

	public boolean isDeleteSuccessDisplayed() {
		return isElementDisplayed(driver, ManagerCustomerPageUI.NO_RECORD_FOUND_MESSAGE);
	}

	public UserHomePageObject openUserHomePage() {
		openPageUrl(driver, "http://live.techpanda.org/");
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
