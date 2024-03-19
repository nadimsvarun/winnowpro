package com.qa.winnowpro.listeners;

import java.util.Arrays;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener implements ITestListener {
	
	
	

	private static ExtentReports extentreport = ExtentManager.createinstance();
	
	public static ThreadLocal<ExtentTest> ttest = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		ExtentTest test =  extentreport.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
		
	   test.assignCategory(result.getTestContext().getSuite().getName());
		/*
		 * methodName = StringUtils.capitalize(StringUtils.join(StringUtils.
		 * splitByCharacterTypeCamelCase(methodName), StringUtils.SPACE));
		 */
		//test.assignCategory(className);
		ttest.set(test);
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Method Name" + methodname.toUpperCase() + "PASSED" +"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ttest.get().pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		

		String exception = Arrays.toString(result.getThrowable().getStackTrace());
		ttest.get().fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception Occured:click to see"+"</font>"+"</b>"+"</summary>"+
		exception.replaceAll(",","<br>")+"</details>"+"\n");
		
		
		
		ttest.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.takescreenshot()).build());
		
		String methodname = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Method Name" + methodname.toUpperCase() +"FAILED" +"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		//test.fail(m);
		ttest.get().log(Status.FAIL, m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Method Name" + methodname.toUpperCase() + "SKIPPED" +"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ttest.get().skip(m);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentreport != null) {

			extentreport.flush();
		}

	}

}
