package com.AvionSchool.lms.listenerutlity;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.AvionSchool.lms.generic.webdriverutlity.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ListnerimplementatationClass implements ITestListener,ISuiteListener{
	public static ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("report config");
		String time = new Date().toString().replace(" ","_").replace(":","_");
		//spark report configration
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReporting/report+"+time+".html");
		spark.config().setDocumentTitle("Avion School Suite Results");
		spark.config().setReportName("LMS Report");
		spark.config().setTheme(Theme.DARK);
		//adding enviorment information and create test
		report=new ExtentReports();
		report.attachReporter(spark);		
		report.setSystemInfo("OS","windows-11");
		report.setSystemInfo("browser","chrome");	
	}
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
		System.out.println("report backup");
	}

	@Override
	public void onTestStart(ITestResult result) {// it will execute before each and every @test method starts so we are place report.createtest method here
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===> started <===");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===> completed <===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String mtdname = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(filepath,mtdname+" "+time);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===> failed <===");		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
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
	/**
	 * 
	 */
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
// itestlistner  is used for  test configration and isuitelistenre is used for suite configration



}
