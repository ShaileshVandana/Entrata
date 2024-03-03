package com.entrata.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
		public static String sparkPath = System.getProperty("user.dir") + "/test-SparkReport/" + "SparkReport" + ".html";
		public static ExtentReports extent = new ExtentReports();
		public static ExtentSparkReporter spark = new ExtentSparkReporter(sparkPath);
		public static ExtentTest test;
		static String testcaseName;
		public static String StatusOfReport = "Pass";
		public ExtentReport(){
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Extent Report");
			extent.attachReporter(spark);
		}
		public static void beforeTest(String msg) {
			test = extent.createTest(msg).assignCategory("Regression Testing").assignDevice("Windows");
			testcaseName = msg;
		}
		public static void afterTest(String Expected, String Actual, ITestResult status) {
			if (status.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.INFO, "Expected Output is: " + Expected + "====" + " Actual Current Output is: " + Actual);
			} else {	
			}
		}
		public static void tearDown(ITestResult status, WebDriver driver) throws IOException {
			if (status.getStatus()==ITestResult.SUCCESS) {
				test.pass("Testcase is pass");
			}else if (status.getStatus()==ITestResult.FAILURE) {
				test.fail("Testcase is fail");
				test.addScreenCaptureFromBase64String(getScreenshot(driver));
				StatusOfReport = "Fail";
				test.info(status.getThrowable());
			}else if (status.getStatus()==ITestResult.SKIP) {
				test.addScreenCaptureFromBase64String(getScreenshot(driver));
				StatusOfReport = "Skip";
			}
			extent.flush();
		}
		public static String getScreenshot(WebDriver driver) throws IOException   {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/test-ScreenShot/" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(source, new File(path));
			byte[] image = IOUtils.toByteArray(new FileInputStream(path));
			return Base64.getEncoder().encodeToString(image);
		}
}
