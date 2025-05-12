package listeners;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class ExtentTestListener implements ITestListener {

	private static ExtentReports extent = ExtentReportManager.getExtentReports();
	// private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private static Map<String, ExtentTest> classTestMap = new HashMap<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		String className = result.getTestClass().getRealClass().getSimpleName();

		ExtentTest parent;

		if (classTestMap.containsKey(className)) {
			parent = classTestMap.get(className);
		} else {
			parent = extent.createTest(className);
			classTestMap.put(className, parent);
		}

		ExtentTest child = parent.createNode(result.getMethod().getMethodName());
		ExtentReportManager.getTest().set(child);
		// ExtentTest extentTest = extent.createTest(result.getTestClass().getName());
		// test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getTest().get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getTest().get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportManager.getTest().get().skip("Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
