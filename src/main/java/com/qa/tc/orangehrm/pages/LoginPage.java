package com.qa.tc.orangehrm.pages;

import com.qa.tc.orangehrm.base.PredefinedActions;
import com.qa.tc.orangehrm.constant.ConstantPath;
import com.qa.tc.orangehrm.uitls.PropertiesFileOperation;

public class LoginPage extends PredefinedActions {

	private static LoginPage loginPage;
	private PropertiesFileOperation properties;

	private LoginPage() {
		properties = new PropertiesFileOperation(ConstantPath.LOGINPAGE);
	}

	public static LoginPage getPageInstance() {
		if (loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}

	public void enterUserName(String userName) {
		enterText(properties.getValue("loginPageUserName"), userName);
	}

	public void enterPassword(String password) {
		enterText(properties.getValue("loginPagePassword"), password);
	}

	public void clickOnSignIn() {
		clickOnElement(properties.getValue("loginPageSignInButton"));
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignIn();
	}

	public String getTitleOfpage() {
		return getCurrentPageTitle();
	}

	public boolean isLogoDisplayed() {
		return isElementDisplayed(properties.getValue("loginPageLogo"));
	}
}