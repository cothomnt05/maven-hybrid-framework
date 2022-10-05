package pageObjects.jquery.dataTable;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
}
