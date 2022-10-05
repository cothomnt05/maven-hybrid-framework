package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static AdminDashboardPO getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminLoginPO getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminPostAddNewPO getAdminPostAddNewPageObject(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}

	public static AdminPostCategoryPO getAdminPostCategoryPageObject(WebDriver driver) {
		return new AdminPostCategoryPO(driver);
	}

	public static AdminPostSearchPO getAdminPostSearchPageObject(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}

	public static AdminPostTagPO getAdminPostTagPageObject(WebDriver driver) {
		return new AdminPostTagPO(driver);
	}

	public static UserHomePO getUserHomePageObject(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserPostDetailPO getUserPostDetailPageObject(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}

	public static UserSearchPO getUserSearchPageObject(WebDriver driver) {
		return new UserSearchPO(driver);
	}

}
