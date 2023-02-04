package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util.ExtentReportr;

public class MyListeners implements ITestListener{
	
	ExtentReports extentReports=ExtentReportr.getExtendsReports();
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		extentTest=extentReports.createTest(result.getName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test got Passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test got Failed");
		extentTest.fail(result.getThrowable());
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
	}
	
	

}
