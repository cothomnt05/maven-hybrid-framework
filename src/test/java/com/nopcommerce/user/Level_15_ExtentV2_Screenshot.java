package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentManager;

public class Level_15_ExtentV2_Screenshot extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
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
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
	}

	@Test
	public void User_01_Register(Method method) {
		// ExtentManager.startTest(method.getName(), "User_01_Register");
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to Register page");
		// registerPage = homePage.openRegisterPage();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		// registerPage.inputToFirstNameTextbox(firstName);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		// registerPage.inputToLastNameTextbox(lastName);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + email + "'");
		// registerPage.inputToEmailTextbox(email);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		// registerPage.inputToPasswordTextbox(password);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm password textbox with value is '" + password + "'");
		// registerPage.inputToConfirmPasswordTextbox(password);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to Register button");
		// registerPage.clickToRegisterButton();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Vefiry Register success message is displayed");
		// Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
		// ExtentManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentManager.startTest(method.getName(), "User_01_Register");
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
		// homePage = registerPage.clickToLogoutLink();
		// loginPage = homePage.openLoginPage();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + email + "'");
		// loginPage.inputToEmailTextbox(email);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		// loginPage.inputToPasswordTextbox(password);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Login button");
		// homePage = loginPage.clickToLoginButton();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify My account link is displayed");
		// Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to My account page");
		// customerInfoPage = homePage.openMyAccountPage();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify Customer infor page is displayed");
		// Assert.assertFalse(customerInfoPage.isCustomerInfoPageIsDisplayed());
		// ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
