package pageObjects.jquery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.dataTable.HomepageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomepageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomepageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageNumberActived(String pageNumber) {
		return isElementDisplayed(driver, HomepageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomepageUI.TOTAL_PAGINATION);

		List<String> allRowsValue = new ArrayList<>();

		for (int i = 1; i <= totalPage; i++) {
			openPagingByPageNumber(String.valueOf(i));

			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomepageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowsValue.add(eachRow.getText());
			}
		}

		for (String rowValue : allRowsValue) {
			System.out.println(rowValue);
		}

		return allRowsValue;
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomepageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomepageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomepageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);

	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomepageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomepageUI.LOAD_DATA_BUTTON);

	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomepageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomepageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));

		sendkeyToElement(driver, HomepageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));

	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomepageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		selectItemInDefaultDropdown(driver, HomepageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));

	}

	public void checkToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomepageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		checkToDefaultCheckboxRadio(driver, HomepageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));

	}

	public void uncheckToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomepageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		uncheckToDefaultCheckbox(driver, HomepageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));

	}

}
