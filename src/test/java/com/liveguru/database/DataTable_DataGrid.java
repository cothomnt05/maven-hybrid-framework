package com.liveguru.database;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.admin.AdminLoginPageObject;
import pageObjects.liveguru.admin.AdminManagerCustomerPageObject;
import pageObjects.liveguru.user.MyAccountPageObject;
import pageObjects.liveguru.user.PageGeneratorManager;
import pageObjects.liveguru.user.UserHomePageObject;
import pageObjects.liveguru.user.UserLoginPageObject;
import pageObjects.liveguru.user.UserRegisterPageObject;

public class DataTable_DataGrid extends BaseTest {
	@Parameters({ "browser", "appUrl" })

	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		email = "automationfc" + generateFakeNumber() + "@gmail.com";// cothomnt95@gmail.com
		password = "123123";

		adminUsername = "user01";
		adminPassword = "guru99com";

		homePage = PageGeneratorManager.getHomePageObject(driver);

		homePage.clickToAccountMenu(driver);

		registerPage = homePage.openRegisterPage();

		Assert.assertTrue(registerPage.isRegisterPageDisplayed());

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		myAccountPage = registerPage.clickToRegisterButton();

		Assert.assertTrue(myAccountPage.isRegisterSuccessDisplayed());

		adminLoginPage = myAccountPage.openAdminPage();
	}

	@Test
	public void DataTable_Admin() {
		adminLoginPage.inputToUsernameTextbox(adminUsername);

		adminLoginPage.inputToPasswordTextbox(adminPassword);
		managerCustomerPage = adminLoginPage.clickToLoginButton();

		if (managerCustomerPage.isPopupDisplayed()) {
			managerCustomerPage.clickToIconClosePopup();
		}

		managerCustomerPage.enterToHeaderTextboxByLabel("Email", email);
		Assert.assertEquals(managerCustomerPage.getTextFromTextboxByColumnNameAtRowNumber("Email"), email);
		Assert.assertEquals(managerCustomerPage.getTextFromTextboxByColumnNameAtRowNumber("Name"), firstName + " " + lastName);

		managerCustomerPage.checkToCheckboxField();
		managerCustomerPage.selectActions("Delete");
		managerCustomerPage.clickToActionSubmitButton();

		managerCustomerPage.handleAlert();

		Assert.assertTrue(managerCustomerPage.isDeleteSuccessDisplayed());

		homePage = managerCustomerPage.openUserHomePage();

		homePage.clickToAccountMenu(driver);
		userLoginPage = homePage.openLoginPage();

		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(password);
		userLoginPage.clickToLoginButton();

		Assert.assertTrue(userLoginPage.isAccountInvalid());

	}

	@AfterClass
	public void afterClass() {
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private String firstName, lastName, email, password, adminUsername, adminPassword;
	private AdminLoginPageObject adminLoginPage;
	private AdminManagerCustomerPageObject managerCustomerPage;
	private UserLoginPageObject userLoginPage;

}
