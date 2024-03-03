package com.entrata.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.entrata.base.testBase;
import com.entrata.pages.HomePage;
import com.entrata.utilities.ExtentReport;
import com.entrata.utilities.TestUtil;

public class HomePageTest extends testBase{
	HomePage homePage;
	ExtentReport extentReport;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeSuite(alwaysRun=true)
	public void openBrowser() {
		extentReport = new ExtentReport();
		EntrataInitialization();
	}
	@BeforeClass(alwaysRun=true)
	public void start() {
		homePage = new HomePage();
	}
	@Test(priority=1, groups = {"SmokeTest", "RegressionTest"})
	public void verifyOpenEntrataHomePageTest()  {
		ExtentReport.beforeTest("Home Page: To verify Home Page of Entrata");	
		ActualOutput = homePage.verifyOpenEntrataHomePage();
		ExpectedOutput = prop.getProperty("url");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=2, groups = {"SmokeTest", "RegressionTest"}, enabled=false)
	public void verifyBrokenLinks() {
		ExtentReport.beforeTest("Home Page: To verify bronken links of Entrata Home Page");	
		ActualOutput = homePage.verifyBrokenLinks();
		ExpectedOutput = HomePage.allLinks;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=3, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataProductsRangeTest() {
		ExtentReport.beforeTest("Home Page: To verify Entrata Products Range");	
		ActualOutput = homePage.verifyEntrataProductsRange();
		ExpectedOutput = prop.getProperty("ProductGroups");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=4, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataPropertyManagementProductsTest() {
		ExtentReport.beforeTest("Home Page: To verify Entrata Property Management Products");	
		ActualOutput = homePage.verifyEntrataPropertyManagementProducts();
		ExpectedOutput = prop.getProperty("PropertyManagementProducts");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=5, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataMarketingAndLeasingProductsTest() {
		ExtentReport.beforeTest("Home Page: To verify Entrata Marketing And Leasing Products");	
		ActualOutput = homePage.verifyEntrataMarketingAndLeasingProducts();
		ExpectedOutput = prop.getProperty("MarketingAndLeasingProducts");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=6, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataAccountingProductsTest() {
		ExtentReport.beforeTest("Home Page: To verify Entrata Accounting Products");	
		ActualOutput = homePage.verifyEntrataAccountingProducts();
		ExpectedOutput = prop.getProperty("AccountingProducts");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=7, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataUtilitiesProductsTest() {
		ExtentReport.beforeTest("Home Page: To verify Entrata Utilities Products");	
		ActualOutput = homePage.verifyEntrataUtilitiesProducts();
		ExpectedOutput = prop.getProperty("Utilities");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=8, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataAllSolutionsTest() {
		ExtentReport.beforeTest("Home Page: To verify Entrata All Solutions");	
		ActualOutput = homePage.verifyEntrataAllSolutions();
		ExpectedOutput = prop.getProperty("Solutions");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult status) throws IOException {
		ExtentReport.afterTest(ExpectedOutput, ActualOutput, status);
		ExtentReport.tearDown(status, driver);
	}
	@AfterSuite(alwaysRun=true)
	public void closeBrowser() throws Exception {
		driver.quit();
	}

}
