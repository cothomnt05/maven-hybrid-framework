package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPO;

public class Post_01_Create_Update_Read_Delete_Search extends BaseTest {
	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostAddNewPO adminAddNewPage;
	private AdminPostSearchPO adminSearchPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserSearchPO userSearchPage;
	private String adminUsername = "automationfc";
	private String adminPassword = "automationfc";
	private String postSearchPageUrl;
	private int randomNumber = generateFakeNumber();
	private String postTitle = "Live Coding Title " + randomNumber;
	private String postBody = "Live Coding Body " + randomNumber;
	private String editTitle = "Edit Title " + randomNumber;
	private String editBody = "Edit Body " + randomNumber;
	private String authorName = "Automation FC";
	private String currentDay = getCurrentDay();
	private String adminUrl, endUserUrl;

	@Parameters({ "browser", "urlAdmin", "urlUser" })

	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		log.info("Pre-Condition - Step 01: Open browser and admin site");
		this.adminUrl = urlAdmin;
		this.endUserUrl = urlUser;
		driver = getBrowserDriver(browserName, this.adminUrl);

		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);

		log.info("Pre-Condition - Step 02: Enter to Username Textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-Condition - Step 03: Enter to Password Textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to Login Button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("CreatePost - Step 01: Click to Post Menu");
		adminSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("CreatePost - Step 02: Get url Post Search Page");
		postSearchPageUrl = adminSearchPage.getUrlPostSearchPage();

		log.info("CreatePost - Step 03: Click to Add New button");
		adminAddNewPage = adminSearchPage.clickToAddNewButton();

		log.info("CreatePost - Step 04: Enter to Post Title textbox");
		adminAddNewPage.enterToPostTitleTextbox(postTitle);

		log.info("CreatePost - Step 05: Enter to post body textbox");
		adminAddNewPage.enterToPostBodyTextbox(postBody);

		log.info("CreatePost - Step 06: Click to Publish button");
		adminAddNewPage.clickToPrePublishButton();

		log.info("CreatePost - Step 07: Click to Pre-Publish button");
		adminAddNewPage.clickToPublishButton();

		log.info("CreatePost - Step 08: Verify Post published message is displayed");
		verifyTrue(adminAddNewPage.isPostPublishedMessageDisplayed("Post published"));
	}

	@Test

	public void Post_02_Search_And_View_Post() {
		log.info("SearchPost - Step 01: Open Post Search Page");
		adminSearchPage = adminAddNewPage.openPostSearchPage(postSearchPageUrl);

		log.info("SearchPost - Step 02: Enter to Search Post Textbox");
		adminSearchPage.enterToSearchPostTextbox(postTitle);

		log.info("SearchPost - Step 03: Click to Search Post Button");
		adminSearchPage.clickToSearchPostButton();

		log.info("SearchPost - Step 04: Verify search table contains '" + postTitle + "'");
		verifyTrue(adminSearchPage.isPostSearchTableDisplay("title", postTitle));

		log.info("SearchPost - Step 05: Verify search table contains '" + authorName + "'");
		verifyTrue(adminSearchPage.isPostSearchTableDisplay("author", authorName));

		log.info("SearchPost - Step 06: Open End User site");
		userHomePage = adminSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("SearchPost - Step 07: Verify post infor displayed at Homepage");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));

		log.info("SearchPost - Step 08: Click to post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("SearchPost - Step 09: Verify post infor displayed at post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("EditPost- Step 01: Open Admin Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, adminUrl);

		log.info("EditPost - Step 02: Click to Post Menu");
		adminSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("EditPost - Step 03: Enter to Search Post Textbox");
		adminSearchPage.enterToSearchPostTextbox(postTitle);

		log.info("EditPost - Step 04: Click to Search Post Button");
		adminSearchPage.clickToSearchPostButton();

		log.info("EditPost- Step 05: Click post title link and navigate to update post page");
		adminAddNewPage = adminSearchPage.clickToPostTitleLink("title", postTitle);

		log.info("EditPost - Step 06: Enter to Post Title textbox");
		adminAddNewPage.enterToPostTitleTextbox(editTitle);

		log.info("EditPost - Step 07: Enter to post body textbox");
		adminAddNewPage.enterToEditPostBodyTextbox(editBody);

		log.info("EditPost - Step 08: Click to Publish button");
		adminAddNewPage.clickToPublishButton();

		log.info("EditPost - Step 09: Verify Post published message is displayed");
		verifyTrue(adminAddNewPage.isPostPublishedMessageDisplayed("Post updated."));

		log.info("EditPost - Step 10: Open Post Search Page");
		adminSearchPage = adminAddNewPage.openPostSearchPage(postSearchPageUrl);

		log.info("EditPost - Step 11: Enter to Search Post Textbox");
		adminSearchPage.enterToSearchPostTextbox(editTitle);

		log.info("EditPost - Step 12: Click to Search Post Button");
		adminSearchPage.clickToSearchPostButton();

		log.info("EditPost - Step 13: Verify search table contains '" + editTitle + "'");
		verifyTrue(adminSearchPage.isPostSearchTableDisplay("title", editTitle));

		log.info("EditPost - Step 14: Verify search table contains '" + authorName + "'");
		verifyTrue(adminSearchPage.isPostSearchTableDisplay("author", authorName));

		log.info("EditPost - Step 15: Open End User site");
		userHomePage = adminSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("EditPost - Step 16: Verify post infor displayed at Homepage");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editTitle, editBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(editTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editTitle, currentDay));

		log.info("EditPost - Step 17: Click to post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editTitle);

		log.info("EditPost - Step 18: Verify post infor displayed at post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editTitle, editBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(editTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(editTitle, currentDay));
	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("DeletePost- Step 01: Open Admin Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, adminUrl);

		log.info("DeletePost - Step 02: Click to Post Menu");
		adminSearchPage = adminDashboardPage.clickToPostMenu();

		log.info("DeletePost - Step 03: Enter to Search Post Textbox");
		adminSearchPage.enterToSearchPostTextbox(editTitle);

		log.info("DeletePost - Step 04: Click to Search Post Button");
		adminSearchPage.clickToSearchPostButton();

		log.info("DeletePost - Step 05: Select Post detail checkbox");
		adminSearchPage.selectPostDetailCheckbox(editTitle);

		log.info("DeletePost - Step 06: Select 'Move to Trash' in Dropdown Actions");
		adminSearchPage.selectActionInDropdown("Move to Trash");

		log.info("DeletePost - Step 07: Click to Apply Button");
		adminSearchPage.clickToApplyButton();

		log.info("DeletePost - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminSearchPage.isdeletedMessageDisplayed("1 post moved to the Trash."));

		log.info("DeletePost - Step 09: Enter to Search Post Textbox");
		adminSearchPage.enterToSearchPostTextbox(editTitle);

		log.info("DeletePost - Step 10: Click to Search Post Button");
		adminSearchPage.clickToSearchPostButton();

		log.info("DeletePost - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminSearchPage.isNotFoundMessageDisplayed("No posts found."));

		log.info("DeletePost - Step 12: Open End User site");
		userHomePage = adminSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("DeletePost - Step 13: Verify post title undisplayed at Home page");
		verifyTrue(userHomePage.isPostTitleUndisplayed(editTitle));

		log.info("DeletePost - Step 13: Enter to Search Textbox");
		userHomePage.enterToSearchTextbox(editTitle);

		log.info("DeletePost - Step 14: Click to Search Button");
		userSearchPage = userHomePage.clickToSearchButton();

		log.info("DeletePost - Step 15: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPage.isNotFoundMessageDisplayed("Nothing Found"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
