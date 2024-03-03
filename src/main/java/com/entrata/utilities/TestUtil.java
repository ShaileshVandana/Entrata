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

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 5;
	
	//Capture screenshot for failed test cases
	public static String getScreenshot(WebDriver driver) throws IOException  {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-ScreenShot/" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(source, new File(path));
		byte[] image = IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(image);
	}
	
	public static void Output(String Actual, String Expected) {
		System.out.println("**********************");
		System.out.println("Actual Output is: " + Actual);
		System.out.println("Expected Output is: " + Expected);
		System.out.println("**********************");
	}

}
