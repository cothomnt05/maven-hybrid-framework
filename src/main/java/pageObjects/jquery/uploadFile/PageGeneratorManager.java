package pageObjects.jquery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getUserHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
