package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportr {
	
	public static ExtentReports getExtendsReports() {
		String ExtentReportFilePath=System.getProperty("user.dir")+"\\reports\\extendreport.html";
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(ExtentReportFilePath);
		sparkReporter.config().setReportName("TutorialsNinja Automation Result");
		sparkReporter.config().setDocumentTitle("TutorialsNinja Test Automation Result");
		
		ExtentReports extentReports= new ExtentReports();
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("Selenium Version", "4.6.1");
		extentReports.setSystemInfo("Operating System", "Windows 10");
		extentReports.setSystemInfo("Executed By", "Sameer Rathod");
		
		return extentReports;
		
		
	}

}
