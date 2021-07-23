package com.qa.tc.orangehrm.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class ITestListenerImpl extends PredefinedActions implements ITestListener, IAnnotationTransformer {
	//String defaultBrowser = "chrome";
	@Override
	public void onTestStart(ITestResult result) {
		String browserName = System.getProperty("browserName");
		/*if(browserName==null || browserName.equals("")) // either handle here or in switch case default case.
			browserName=defaultBrowser;*/
		start(browserName, "https://radhas-trials71.orangehrmlive.com/");
		ExtentReportClass.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportClass.pass(result);
		tearDown();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String currentTestmethodName = result.getMethod().getMethodName();
		captureScreenShot(currentTestmethodName);
		ExtentReportClass.fail(result);
		tearDown();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportClass.skip(result);
		tearDown();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// param from cmd
		ExtentReportClass.initReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportClass.flushReports();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryTestCase.class);
	}

}
