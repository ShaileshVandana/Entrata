package com.entrata.utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
	static int passcount=0, failcount=0, skipcount=0;
	ExtentReport extentReport;
	
	@Override		
    public void onStart(ITestContext Result) {
    	extentReport = new ExtentReport();
		try {
		ScreenRecording.startRecord("Start");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	@Override		
    public void onFinish(ITestContext Result) {
		try {
			ScreenRecording.stopRecord();
			} catch(Exception e) {
				e.printStackTrace();
			}
    }
    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) { 		
    }		
    @Override		
    public void onTestFailure(ITestResult Result) {
    	System.out.println(Result.getThrowable().getMessage());
    	System.out.println("The name of the testcase failed is :" + Result.getName());
    	failcount++;
    }		
    @Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}
    @Override		
    public void onTestSkipped(ITestResult Result) {
    	System.out.println(Result.getThrowable().getMessage());
    	System.out.println("The name of the testcase Skipped is :" + Result.getName());
    	ExtentReport.test.info(Result.getThrowable().getMessage());
    	ExtentReport.test.skip("Testcase: "  + Result.getName() + " is skip");
    	skipcount++;
    }		
    @Override		
    public void onTestStart(ITestResult Result) {
    	System.out.println(Result.getName()+" test case started");
    }
    @Override		
    public void onTestSuccess(ITestResult Result) {
    	System.out.println("The name of the testcase passed is :" + Result.getName());
    	passcount++;
    }
	
}
