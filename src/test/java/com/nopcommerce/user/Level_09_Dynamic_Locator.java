package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserBackInStockSubscriptionPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserDownloadableProductPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserOrderPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserOrderPageObject orderPage;
	private UserDownloadableProductPageObject downloadableProductPage;
	private UserBackInStockSubscriptionPageObject backInStockSubscriptionPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = "afc" + generateFakeNumber() + "@mail.vn";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();

		Assert.assertTrue(customerInfoPage.isCustomerInfoPageIsDisplayed());
	}

	@Test
	public void User_03_Dynamic_Page() {
		addressPage = (UserAddressPageObject) customerInfoPage.openPageAtMyAccountByName(driver, "Addresses");

		orderPage = (UserOrderPageObject) addressPage.openPageAtMyAccountByName(driver, "Orders");

		downloadableProductPage = (UserDownloadableProductPageObject) orderPage.openPageAtMyAccountByName(driver, "Downloadable products");

		backInStockSubscriptionPage = (UserBackInStockSubscriptionPageObject) downloadableProductPage.openPageAtMyAccountByName(driver, "Back in stock subscriptions");

		rewardPointPage = (UserRewardPointPageObject) backInStockSubscriptionPage.openPageAtMyAccountByName(driver, "Reward points");

		changePasswordPage = (UserChangePasswordPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Change password");

		myProductReviewPage = (UserMyProductReviewPageObject) changePasswordPage.openPageAtMyAccountByName(driver, "My product reviews");

		customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Customer info");
	}

	@Test
	public void User_04_Dynamic_Page_02() {
		customerInfoPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);

		addressPage.openPageAtMyAccountByPageName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);

		orderPage.openPageAtMyAccountByPageName(driver, "Downloadable products");
		downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);

		downloadableProductPage.openPageAtMyAccountByPageName(driver, "Back in stock subscriptions");
		backInStockSubscriptionPage = PageGeneratorManager.getBackInStockSubscriptionPage(driver);

		backInStockSubscriptionPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);

		rewardPointPage.openPageAtMyAccountByPageName(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getChangePasswordPage(driver);

		changePasswordPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);

		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
