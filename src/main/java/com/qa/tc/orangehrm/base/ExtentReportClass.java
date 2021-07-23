package com.qa.tc.orangehrm.base;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.tc.orangehrm.constant.ConstantPath;

public final class ExtentReportClass {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initReport() {
		extent = new ExtentReports();
		ExtentSparkReporter extentspark = new ExtentSparkReporter(ConstantPath.EXTENTREPORT+"extent-report.html");
		extentspark.config().setTheme(Theme.STANDARD);
		extentspark.config().setReportName(System.getProperty("xmlsuite"));
		extentspark.config().setDocumentTitle("OrangeHRM Extent Report");
		extent.attachReporter(extentspark); // added spark layout by extenrsparkreporter to the created report file
	}
	
	public static void flushReports() {
		extent.flush();
	}
	
	public static void createTest(String testCaseName) {
		test = extent.createTest(testCaseName);
		test.createNode("Test Case - "+ testCaseName);
	}
	
	public static void pass(ITestResult result) {
		test.log(Status.PASS, "Test case is passed - "+result.getMethod().getMethodName());
	}
	
	public static void fail(ITestResult result) {
		test.addScreenCaptureFromBase64String(PredefinedActions.captureScreenShotasBASE64(result.getMethod().getMethodName()));
		test.log(Status.FAIL, result.getThrowable());
	}
	
	public static void skip(ITestResult result) {
		test.log(Status.SKIP, "Test is skipped - "+result.getThrowable());
	}

}
