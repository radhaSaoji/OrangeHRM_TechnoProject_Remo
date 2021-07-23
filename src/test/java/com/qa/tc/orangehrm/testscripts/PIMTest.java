package com.qa.tc.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tc.orangehrm.pages.LoginPage;
import com.qa.tc.orangehrm.pages.PimPage;


public class PIMTest extends TestBase {
	@Test
	public void count_employees_gender_wise() {
		LoginPage loginPage = LoginPage.getPageInstance();
		loginPage.login("Admin", "SYpifJ2V2@");
		PimPage pimPage = PimPage.getPageInstance();
		pimPage.clickOnPimAndClickOn("reports");
		Assert.assertTrue(pimPage.verifyReportNameDisplayed(), "Report Name Not Displayed on PIM Page");
		pimPage.clickOnReportName("Gender");
		Assert.assertEquals(pimPage.verifyCorrectIndividualReportNameDisplayed("Gender"), "Gender");
		Assert.assertTrue(pimPage.verifyAllChartsDisplayed(), "Chart not visible");
		Assert.assertEquals(pimPage.getChartValue().size(), pimPage.getTableValue().size());
	}

	@Test(enabled = false)
	public void verify_reporting_methods() {
		LoginPage loginPage = LoginPage.getPageInstance();
		loginPage.login("admin", "SYpifJ2V2@");
		PimPage pimPage = PimPage.getPageInstance();
		pimPage.clickOnPimAndClickOn("configuration");
		pimPage.clickOnReportingMethods();
		Assert.assertTrue(pimPage.verifyTitledisplayed("Reporting Methods"));
		Assert.assertTrue(pimPage.verifyAllCheckBoxesAreEnabled(), "Check boxes not Enabled");

		int totalCheckBoxes = pimPage.getAllCheckBoxList().size();
		pimPage.clickOnMoreAndClickOn("Select All");
		int checkedCheckbox = pimPage.getAllCheckboxWhicChecked().size();
		Assert.assertEquals(checkedCheckbox, totalCheckBoxes, "Selecte All function working fine");
		pimPage.clickOnMoreAndClickOn("Deselect All");

		pimPage.clickOnAddOption();
		pimPage.addReportingMethod("Flat Structure");
		pimPage.clickOnSaveButtonOnreporting();
		Assert.assertTrue(pimPage.validateAddedMethodDisplayed("Flat Structure"),
				"Newly added reporting method is not present");

	}

}
