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
		
		if(extent==null) {
			ExtentSparkReporter reporter=new ExtentSparkReporter("src/test/resources/Reports/Api-test-report.html");
			reporter.config().setDocumentTitle("Api Testing Report");
			reporter.config().setReportName("Rest Assured Test Execution");
			reporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.setSystemInfo("Tester", "KKReddy");
			extent.setSystemInfo("Env", "Staging");
			extent.attachReporter(reporter);
		}
		
//		extent=new ExtentReports();
//		ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/Reports/Api-test-report.html");
//		spark.config().setDocumentTitle("Api Testing Report");
//		spark.config().setReportName("Rest Assured Test Execution");
//		spark.config().setTheme(Theme.DARK);
//		extent.setSystemInfo("Tester", "KKReddy");
//		extent.setSystemInfo("Env", "Staging");
//		extent.attachReporter(spark);
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
