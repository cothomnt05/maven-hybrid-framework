package com.saucedemo.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucedemo.LoginPageObject;
import pageObjects.saucedemo.PageGeneratorManager;
import pageObjects.saucedemo.ProductPageObject;

public class Level_19_Sort_Data extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private String userName, password;
	private ProductPageObject productPage;

	@Parameters({ "browser", "urlPage" })

	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		log.info("Pre-Condition - Step 01: Open browser and navigate to demo site");
		driver = getBrowserDriver(browserName, urlPage);
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		userName = "standard_user";
		password = "secret_sauce";

		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + userName);
		loginPage.enterToUsername(userName);

		log.info("Pre-Condition - Step 03: Enter to Password textbox with value: " + password);
		loginPage.enterToPassword(password);

		log.info("Pre-Condition - Step 04: Click to Login button");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_By_Name() {
		log.info("SortByName - Step 01: Sort by name from A to Z");
		productPage.selectItemSortInDropdown("Name (A to Z)");

		log.info("SortByName - Step 02: Verify list item is sorted by name from A to Z");
		verifyTrue(productPage.isListItemSortedByAscName());

		log.info("SortByName - Step 03: Sort by name from Z to A");
		productPage.selectItemSortInDropdown("Name (Z to A)");

		log.info("SortByName - Step 04: Verify list item is sorted by name from Z to A");
		verifyTrue(productPage.isListItemSortedByDescName());

	}

	@Test
	public void Sort_02_By_Price() {
		log.info("SortByPrice - Step 01: Sort by price from low to high");
		productPage.selectItemSortInDropdown("Price (low to high)");

		log.info("SortByPrice - Step 02: Verify list item is sorted by price from low to high");
		verifyTrue(productPage.isListItemSortedByAscPrice());

		log.info("SortByPrice - Step 03: Sort by price from high to low");
		productPage.selectItemSortInDropdown("Price (high to low)");

		log.info("SortByPrice - Step 04: Verify list item is sorted by price from high to low");
		verifyTrue(productPage.isListItemSortedByDescPrice());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
