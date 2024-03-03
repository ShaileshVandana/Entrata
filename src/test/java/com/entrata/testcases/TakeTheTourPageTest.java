package com.entrata.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.entrata.base.testBase;
import com.entrata.pages.TakeTheTourPage;
import com.entrata.utilities.ExtentReport;
import com.entrata.utilities.TestUtil;

public class TakeTheTourPageTest extends testBase{
	
	TakeTheTourPage takeTheTourPage;
	
	public TakeTheTourPageTest() {
		super();
	}

	@BeforeClass(alwaysRun=true)
	public void start() {
		takeTheTourPage = new TakeTheTourPage();
	}
	
	@Test(priority=1, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEntrataTakeTheTourButtonTest() throws InterruptedException  {
		ExtentReport.beforeTest("Take The Tour Page: To verify TakeTheTourButton");	
		ActualOutput = takeTheTourPage.verifyEntrataTakeTheTourButton();
		ExpectedOutput = prop.getProperty("urlTTT");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=2, groups = {"SmokeTest", "RegressionTest"})
	public void verifyFirstNameTextFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify FirstName field");	
		ActualOutput = takeTheTourPage.verifyFirstNameTextField();
		ExpectedOutput = TakeTheTourPage.FirstNameField;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=3, groups = {"SmokeTest", "RegressionTest"})
	public void verifyLastNameTextFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify LastName field");	
		ActualOutput = takeTheTourPage.verifyLastNameTextField();
		ExpectedOutput = TakeTheTourPage.LastNameField;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=4, groups = {"SmokeTest", "RegressionTest"})
	public void verifyEmailTextFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify Email field");	
		ActualOutput = takeTheTourPage.verifyEmailTextField();
		ExpectedOutput = TakeTheTourPage.EmailField;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=5, groups = {"SmokeTest", "RegressionTest"})
	public void verifyCompanyNameFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify Company Name field");	
		ActualOutput = takeTheTourPage.verifyCompanyNameField();
		ExpectedOutput = TakeTheTourPage.CompanyField;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=6, groups = {"SmokeTest", "RegressionTest"})
	public void verifyPhoneFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify Phone Number field");	
		ActualOutput = takeTheTourPage.verifyPhoneField();
		ExpectedOutput = TakeTheTourPage.PhoneField;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=7, groups = {"SmokeTest", "RegressionTest"})
	public void verifyUnitCountDropdownFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify UnitCount Dropdown field");	
		ActualOutput = takeTheTourPage.verifyUnitCountDropdownField();
		ExpectedOutput = prop.getProperty("UnitCountDropdown");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=8, groups = {"SmokeTest", "RegressionTest"})
	public void verifyTitleFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify Title field");	
		ActualOutput = takeTheTourPage.verifyTitleField();
		ExpectedOutput = TakeTheTourPage.TitleField;
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=9, groups = {"SmokeTest", "RegressionTest"})
	public void verifydemoRequestDropdownFieldTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify demoRequest Dropdown field");	
		ActualOutput = takeTheTourPage.verifydemoRequestDropdownField();
		ExpectedOutput = prop.getProperty("demoRequest");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@Test(priority=10, groups = {"SmokeTest", "RegressionTest"})
	public void verifyWatchDemoButtonTest() {
		ExtentReport.beforeTest("Take The Tour Page: To verify demoRequest WatchDemo Button");	
		ActualOutput = takeTheTourPage.verifyWatchDemoButton();
		ExpectedOutput = prop.getProperty("urlTTT");
		TestUtil.Output(ActualOutput, ExpectedOutput);
		Assert.assertEquals(ActualOutput, ExpectedOutput);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult status) throws IOException{
		ExtentReport.afterTest(ExpectedOutput, ActualOutput, status);
		ExtentReport.tearDown(status, driver);
	}
}
