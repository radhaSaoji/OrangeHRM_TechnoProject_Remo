package com.qa.tc.orangehrm.constant;

public class ConstantPath {

	/**
	 * Selenium Configs
	 */
	public static final String CHROMEDRIVER = "webdriver.chrome.driver";
	public static final String CHROMEDRIVEREXE = "./src/test/resources/chromedriver.exe";
	public static final int AVGWAIT = 30;

	/**
	 * Test Data Configs
	 */
	public static final String TESTDATA = "./src/test/resources/testData/";

	/**
	 * Pages Locator Files
	 */
	private static final String BASEDIR = "./src/main/resources/Config/";
	public static final String DASHBOARDPAGE = BASEDIR + "dashboardPage.properties";
	public static final String LOGINPAGE = BASEDIR + "loginPage.properties";
	public static final String PIMPAGE = BASEDIR + "pimPage.properties";
	
	/*
	 * Extent report location
	 */
	public static final String EXTENTREPORT = "./src/test/resources/reports/";
}
