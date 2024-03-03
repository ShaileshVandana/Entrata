package com.entrata.base;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import com.entrata.utilities.browserFactory;


public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String ExpectedOutput, ActualOutput;
	
	public testBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/com/entrata/Configuration/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void EntrataInitialization()  {
		driver = browserFactory.browser(driver, prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

}
