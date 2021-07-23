package com.qa.tc.orangehrm.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.qa.tc.orangehrm.base.PredefinedActions;
import com.qa.tc.orangehrm.constant.ConstantPath;
import com.qa.tc.orangehrm.uitls.PropertiesFileOperation;

public class PimPage extends PredefinedActions {

	private static PimPage pimPage;
	private PropertiesFileOperation properties;

	private PimPage() {
		properties = new PropertiesFileOperation(ConstantPath.PIMPAGE);
	}

	public static PimPage getPageInstance() {
		if (pimPage == null)
			pimPage = new PimPage();
		return pimPage;
	}

	public void clickOnPimAndClickOn(String sectionName) {
		clickOnElement(properties.getValue("pimTab"));
		switch (sectionName.toLowerCase()) {
		case "reports":
			clickOnElement(properties.getValue("reports"));
			break;

		case "configuration":
			clickOnElement(properties.getValue("configuration"));
			break;

		default:
			break;
		}
	}

	public void clickOnReportingMethods() {
		clickOnElement(properties.getValue("reportingMethods"));
	}

	public boolean verifyReportNameDisplayed() {
		return isElementDisplayed(properties.getValue("reportTitleName"));
	}

	public void clickOnReportName(String reportName) {
		clickOnElement(String.format(properties.getValue("reportName"), reportName));
	}

	public String verifyCorrectIndividualReportNameDisplayed(String reportName) {
		return getElementText(String.format(properties.getValue("individualReportTitle"), reportName));
	}

	public boolean verifyAllChartsDisplayed() {
		List<WebElement> list = getAllElements(properties.getValue("chartElement"), true);
		for (WebElement element : list)
			if (!element.isDisplayed())
				return false;
		return true;
	}

	public HashMap<String, Integer> getChartValue() {
		scrollToElement(getElement(properties.getValue("reportNameOnChart"), true));
		int numberOfBars = getAllElements(properties.getValue("chartValues"), true).size();
		HashMap<String, Integer> mapOfGenderCount = new HashMap<String, Integer>();
		for (int index = 1; index <= numberOfBars; index++) {
			moveToElement(getElement(String.format(properties.getValue("chartBar"), index), true));
			String genderValue = getElementText(properties.getValue("chartBarTitle"));
			String genderCount = getElementText(properties.getValue("chaertBarValue"));
			mapOfGenderCount.put(genderValue, Integer.parseInt(genderCount));
		}
		return mapOfGenderCount;
	}

	public HashMap<String, Integer> getTableValue() {
		int numberOfRows = getAllElements(properties.getValue("tableValue"), true).size();
		HashMap<String, Integer> mapOfGenderFromTable = new HashMap<String, Integer>();
		String keyGender = "";
		int valueGender = 0;
		for (int index = 1; index <= numberOfRows; index++) {
			keyGender = getElementText(String.format(properties.getValue("tableRows"), index));
			valueGender = Integer.parseInt(getElementText(String.format(properties.getValue("tableEachRowValue"), index)));
			mapOfGenderFromTable.put(keyGender, valueGender);
		}
		return mapOfGenderFromTable;
	}

	public boolean verifyTitledisplayed(String title) {
		return isElementDisplayed(String.format(properties.getValue("reportTitle"), title));
	}

	public boolean verifyAllCheckBoxesAreEnabled() {
		List<WebElement> list = getAllElements(properties.getValue("checkBoxesEnabled"), true);
		for (WebElement element : list)
			if (!element.isDisplayed())
				return false;
		return true;
	}

	public List<WebElement> getAllCheckBoxList() {
		return getAllElements(properties.getValue("checkBoxesEnabled"), true);
	}

	public void clickOnMoreAndClickOn(String action) {
		clickOnElement(properties.getValue("moreOptions"));
		clickOnElement(String.format(properties.getValue("buttonAction"), action));
	}

	public List<WebElement> getAllCheckboxWhicChecked() {
		return getAllElements(properties.getValue("allCheckedBoxed"), true);
	}

	public void clickOnAddOption() {
		clickOnElement(properties.getValue("addOption"));
	}

	public void addReportingMethod(String methodName) {
		enterText(properties.getValue("reportingMethod"), methodName);
	}

	public void clickOnSaveButtonOnreporting() {
		clickOnElement(properties.getValue("saveButtonOnReportMethod"));
	}

	public boolean validateAddedMethodDisplayed(String methodsName) {
		return getElement(String.format(properties.getValue("reportingMethodElement"), methodsName), true)
				.isDisplayed();
	}

}