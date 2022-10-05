package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;

@Listeners(commons.MethodListener.class)
public class Topic_14_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\libWebDriverManager\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		System.out.println("Assert 01 - Pass");
		verifyEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

		System.out.println("Assert 02 - Failed");
		verifyEquals(driver.getTitle(), "Facebook – log in or sign up...");

		System.out.println("Assert 03 - Pass");
		verifyTrue(driver.findElement(By.xpath("//input[@name = 'login_source']")).isDisplayed());

		System.out.println("Assert 04 - Failed");
		verifyTrue(driver.findElement(By.xpath("//input[@data-testid = 'royal_email']")).isDisplayed());

		System.out.println("Assert 05 - Pass");
		verifyTrue(driver.findElement(By.xpath("//div[@id='reg_pages_msg']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
