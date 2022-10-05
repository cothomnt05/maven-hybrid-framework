package pageObjects.jquery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadFiles.HomepageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomepageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomepageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomepageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomepageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomepageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomepageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

	public void clickStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomepageUI.START_BUTTON);

		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}

	}

}
