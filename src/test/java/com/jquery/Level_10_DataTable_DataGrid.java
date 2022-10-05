package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.dataTable.PageGeneratorManager;
import pageObjects.jquery.dataTable.UserHomePageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {

	@Parameters({ "browser", "appUrl" })

	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	public void Table_01() {
		homePage.openPagingByPageNumber("2");
		homePage.isPageNumberActived("2");

		homePage.openPagingByPageNumber("18");
		homePage.isPageNumberActived("18");

		homePage.openPagingByPageNumber("9");
		homePage.isPageNumberActived("9");

		homePage.openPagingByPageNumber("5");
		homePage.isPageNumberActived("5");

	}

	public void Table_02() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
	}

	public void Table_03() {
		homePage.getValueEachRowAtAllPage();
	}

	@Test
	public void Table_04_Action_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(2);

		homePage.enterToTextboxAtRowNumberByColumnName("Album", "1", "Michael");
		homePage.enterToTextboxAtRowNumberByColumnName("Artist", "3", "SAb");
		homePage.enterToTextboxAtRowNumberByColumnName("Year", "2", "2020");
		homePage.enterToTextboxAtRowNumberByColumnName("Price", "4", "500");

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Korea");

		homePage.uncheckToTextboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.uncheckToTextboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.checkToTextboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.uncheckToTextboxByColumnNameAtRowNumber("With Poster?", "4");
		homePage.checkToTextboxByColumnNameAtRowNumber("With Poster?", "5");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
}
