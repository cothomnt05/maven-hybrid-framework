package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "xpath=//div[@id='wpbody-content']//a[text()='Add New']";
	public static final String SEARCH_POST_TEXTBOX = "id=post-search-input";
	public static final String SEARCH_POST_BUTTON = "id=search-submit";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String CHECKBOX_POST_BY_POST_TITLE = "xpath=//table[contains(@class,'table-view-list posts')]//a[text()='%s']//ancestor::td/preceding-sibling::th/input";
	public static final String ACTIONS_DROPDOWN = "id=bulk-action-selector-top";
	public static final String APPLY_ACTION_BUTTON = "id=doaction";
	public static final String DELETED_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NOT_POST_FOUND_MESSAGE = "xpath=//table//td[text()='%s']";
}
