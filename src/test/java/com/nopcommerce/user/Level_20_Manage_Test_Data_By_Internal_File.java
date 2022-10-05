package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_20_Manage_Test_Data_By_Internal_File extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private String day, month, year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = "afc" + generateFakeNumber() + "@mail.vn";
		firstName = UserData.FIRST_NAME;
		lastName = UserData.LAST_NAME;
		password = UserData.PASSWORD;
		day = UserData.DAY;
		month = UserData.MONTH;
		year = UserData.YEAR;

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		registerPage.checkToRadioButtonByLabel(driver, "Female");

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + email + "'");
		registerPage.inputToTextboxByID(driver, "Email", email);

		registerPage.checkToCheckboxButtonByLabel(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToTextboxByID(driver, "Password", password);

		log.info("Register - Step 06: Enter to Confirm password textbox with value is '" + password + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 07: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 08: Vefiry Register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + email + "'");
		loginPage.inputToTextboxByID(driver, "Email", email);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify My account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to My account page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("My Account - Step 02: Verify Customer infor page is displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageIsDisplayed());

		log.info("My Account - Step 03: Verify 'Firstname' value is correctly");
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("My Account - Step 04: Verify 'Lastname' value is correctly");
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("My Account - Step 05: Verify 'Email' value is correctly");
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), email);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
