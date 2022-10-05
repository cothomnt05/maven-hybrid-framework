package pageUIs.liveguru;

public class ManagerCustomerPageUI {
	public static final String CLOSE_ICON_POPUP = "xpath=//a[@title='close']";
	public static final String POPUP = "id=message-popup-window";
	public static final String REGISTER_LINK = "xpath=//a[text()='Register']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String FILTER_BY_COLUMN_INDEX = "xpath=//thead/tr[@class='filter']/th[%s]//input";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//table[@id='customerGrid_table']//tbody//td[%s]";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//table[@id='customerGrid_table']//tbody//td/input[@type='checkbox']";
	public static final String ACTIONS_DROPDOWN = "id=customerGrid_massaction-select";
	public static final String ACTION_SUBMIT_BUTTON = "xpath=//span[text()='Submit']";
	public static final String NO_RECORD_FOUND_MESSAGE = "xpath=//td[text()='No records found.']";
}
