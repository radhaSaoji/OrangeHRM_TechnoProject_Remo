package com.qa.tc.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.qa.tc.orangehrm.base.PredefinedActions;
import com.qa.tc.orangehrm.constant.ConstantPath;
import com.qa.tc.orangehrm.uitls.PropertiesFileOperation;

public class DashboardPage extends PredefinedActions {

	private static DashboardPage dashboardPage;
	private PropertiesFileOperation properties;

	private DashboardPage() {
		properties = new PropertiesFileOperation(ConstantPath.DASHBOARDPAGE);
	}

	public static DashboardPage getPageInstance() {
		if (dashboardPage == null)
			dashboardPage = new DashboardPage();
		return dashboardPage;
	}

	public boolean isUSerProfileDisplayed() {
		return isElementDisplayed(properties.getValue("dashboardPageProfile"));
	}

	public void clickOnArrowIcon() {
		clickOnElement(properties.getValue("dashboardPageArrowDown"));
	}

	public boolean verifyUserMenuDisplayed() {
		return isElementDisplayed(properties.getValue("dashboardPageUserMenuList"));
	}

	public void clickOnAboutLink() {
		clickOnElement(properties.getValue("dashboardPageAboutLink"));
	}

	public String getEmployeeNumbers() {
		return getElementText(properties.getValue("dashboardPageEmpployeeNumber"));
	}

	public void clickOnOkyButtonOnPopup() {
		clickOnElement(properties.getValue("dashboardPagePopupOKButton"));
	}

	public boolean verifyAllSectionAreCollapsible() {
		List<WebElement> collesibleList = getAllElements(properties.getValue("dashboardPageCollapsibleList"), true);
		for (WebElement element : collesibleList)
			if (!element.getAttribute("class").equals("collapsible-body"))
				return false;
		return true;
	}

	public boolean verifyAllWidgetDisplayed() {
		List<WebElement> list = getAllElements(properties.getValue("dashboardPageWidgetMenu"), true);
		for (WebElement widget : list) {
			if (!widget.isDisplayed())
				return false;
		}
		return true;
	}

	public List<WebElement> verifyAllWidgetList() {
		return getAllElements(properties.getValue("dashboardPageWidgetMenu"), true);
	}

	public void clickOnAdminAndThenClickOn(String sectionName, String subSection) {
		clickOnElement(properties.getValue("dashBoardPageAdminMenu"));
		switch (sectionName.toLowerCase()) {
		case "user management":
			clickOnElement(properties.getValue("dashboardPageUserManagment"));
			switch (subSection.toLowerCase()) {
			case "users":
				clickOnElement(properties.getValue("dashboardPageUsers"));
				break;

			default:
				break;
			}
			break;

		default:
			break;
		}
	}

	public void clickOnPIMAndThenClickOn(String sectionName) {
		clickOnElement(properties.getValue("dashboardPagePIMMenu"));
		switch (sectionName.toLowerCase()) {
		case "add employee":
			clickOnElement(properties.getValue("dashboardPageAddEmployeeSeubMenu"));
			break;
		case "employee list":
			clickOnElement(properties.getValue("dashboardPageEmployeeListSubMenu"));
			break;
		default:
			break;
		}
	}

}
