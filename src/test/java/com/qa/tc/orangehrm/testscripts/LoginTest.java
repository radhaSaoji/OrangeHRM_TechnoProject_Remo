package com.qa.tc.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tc.orangehrm.pages.DashboardPage;
import com.qa.tc.orangehrm.pages.LoginPage;

public final class LoginTest extends TestBase {

	@Test
	public void verify_user_able_to_login_and_11_quick_access_is_displayed() {
		
		Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo not displayed on Login Page");
		LoginPage.getPageInstance().login("admin", "SYpifJ2V2@");
		DashboardPage dashboardPage = DashboardPage.getPageInstance();
		Assert.assertEquals(11, dashboardPage.verifyAllWidgetList().size());
		Assert.assertTrue(dashboardPage.verifyAllWidgetDisplayed(), "Some Widgets not displayed on Dashboard Page");
		Assert.assertTrue(dashboardPage.isUSerProfileDisplayed(), "User Profile not displayed on Dashboard Page");
	}

	
}
