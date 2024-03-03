package com.entrata.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.entrata.base.testBase;
import com.entrata.utilities.dummyTestData;

public class TakeTheTourPage extends testBase{
	
	public static String FirstNameField, LastNameField, EmailField, CompanyField, PhoneField, TitleField;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions actions = new Actions(driver);
	
	@FindBy(xpath="//a[@title='Take the tour (demo button)']")
	WebElement TakeTheTourButton;
	
	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Company")
	WebElement Company;
	
	@FindBy(id="Phone")
	WebElement Phone;
	
	@FindBy(id="Unit_Count__c")
	WebElement UnitCountDropdown;
	
	@FindBy(id="Title")
	WebElement Title;
	
	@FindBy(id="demoRequest")
	WebElement demoRequest;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement WatchDemoButton;
	
	public TakeTheTourPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyEntrataTakeTheTourButton() throws InterruptedException {
		js.executeScript("window.scrollBy(0,800)");
		TakeTheTourButton.sendKeys(Keys.ENTER);
		String TourPage = driver.getCurrentUrl();
		return TourPage;
	}
	
	public String enterData(WebElement ele, String input) {
		ele.sendKeys(input);
		ele.sendKeys(Keys.TAB);
		String output = ele.getAttribute("value");
		return output;
	}
	
	public String verifyFirstNameTextField() {
		FirstNameField = dummyTestData.createTestName(10);
		String output = enterData(FirstName, FirstNameField);
		return output;
	}
	
	public String verifyLastNameTextField() {
		LastNameField = dummyTestData.createTestName(10);
		String output = enterData(LastName, LastNameField);
		return output;
	}
	
	public String verifyEmailTextField() {
		EmailField = dummyTestData.createTestEmailAddress(5);
		String output = enterData(Email, EmailField);
		return output;
	}
	
	public String verifyCompanyNameField() {
		CompanyField = dummyTestData.createTestName(15);
		String output = enterData(Company, CompanyField);
		return output;
	}
	
	public String verifyPhoneField() {
		PhoneField = dummyTestData.createTestMobileNumber(10);
		String output = enterData(Phone, PhoneField);
		return output;
	}
	
	public String verifyUnitCountDropdownField() {
		js.executeScript("window.scrollBy(0,600)");
		Select select = new Select(UnitCountDropdown);
		select.selectByVisibleText(prop.getProperty("UnitCountDropdown"));
		WebElement option = select.getFirstSelectedOption();
		String output = option.getText();
		return output;
		
	}
	
	public String verifyTitleField() {
		TitleField = dummyTestData.createTestMobileNumber(10);
		String output = enterData(Title, TitleField);
		return output;
	}
	
	public String verifydemoRequestDropdownField() {
		Select select = new Select(demoRequest);
		select.selectByVisibleText(prop.getProperty("demoRequest"));
		WebElement option = select.getFirstSelectedOption();
		String output = option.getText();
		return output;
	}
	
	public String verifyWatchDemoButton() {
		WatchDemoButton.click();
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

}
