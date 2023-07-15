package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AmznListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println(result+"successful");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+"failed");
	
	}

	}
