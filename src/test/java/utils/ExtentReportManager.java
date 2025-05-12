package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	
	public static ExtentReports getExtentReports() {
		
		
		//tring reportName=(groupName == null || groupName.isBlank()) ? "Api-test-report" : groupName;
		
		//System.out.println("Report name is : "+ExtentTestListener.testName);
		String env=System.getProperty("env");
		String user=System.getProperty("user.name");
		if(extent==null) {
			ExtentSparkReporter reporter=new ExtentSparkReporter("Reports/"+"test-report"+".html");
			reporter.config().setDocumentTitle("Api Testing Report");
			reporter.config().setReportName("Rest Assured Test Execution");
			reporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.setSystemInfo("User", user);
			extent.setSystemInfo("Env", env);
			extent.attachReporter(reporter);
		}
		
		return extent;
	}
	
	public static ThreadLocal<ExtentTest> getParentTest(){
		return parentTest;
	}
	
	public static ThreadLocal<ExtentTest> getTest(){
		return test;
	}
	
	public static void flushReport() {
		extent.flush();
	}
	

}
