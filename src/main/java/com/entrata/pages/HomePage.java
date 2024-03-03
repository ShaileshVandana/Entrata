package com.entrata.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.entrata.base.testBase;

public class HomePage extends testBase{
	public static String allLinks;
	private String beforeXpath = "//a[text()='";
	private String afterXpath = "']/following-sibling::a[@class='standard-footer-link']";
	Actions actions = new Actions(driver);
	
	@FindBy(xpath="//div[text()='Products']")
	private WebElement Products;
	
	@FindBy(tagName = "a")
	private List<WebElement> LinksList;
	
	@FindBy(xpath="//a[@class='title-footer-link']")
	private List<WebElement> ProductsRange;
	
	@FindBy(xpath="//div[text()='Solutions']")
	private WebElement Solutions;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOpenEntrataHomePage() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	
	public String verifyBrokenLinks() {
		int AllLinks = LinksList.size();
		System.out.println("Total number of links are: " + AllLinks);
		allLinks = String.valueOf(AllLinks);
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i=0; i<LinksList.size(); i++) {
			System.out.println(LinksList.get(i).getAttribute("href"));
			if(LinksList.get(i).getAttribute("href") != null) {
				activeLinks.add(LinksList.get(i));
			}
		}
		int SizeOfAllActiveLinks = activeLinks.size();
		System.out.println("Total Number Of Active Links are: " + SizeOfAllActiveLinks);
		String ActiveLinks = Integer.toString(SizeOfAllActiveLinks);
		return ActiveLinks;
	}
	
	public String returnProductList(List<WebElement> ele) {
		List<String> Type = new ArrayList<String>();
		for(int i=0; i<ele.size(); i++) {
			Type.add(ele.get(i).getText());	
		}
		String ProductList = Type.toString();
		return ProductList;
	}
	
	public String verifyEntrataProductsRange() {
		actions.moveToElement(Products).build().perform();
		String allProductGroups = returnProductList(ProductsRange);
		return allProductGroups;
	}
	
	public String verifyEntrataPropertyManagementProducts() {
		List<WebElement> PropertyManagementProducts = driver.findElements(By.xpath(beforeXpath + "Property Management" + afterXpath));
		String PropertyManagementProductList = returnProductList(PropertyManagementProducts);
		return PropertyManagementProductList;
	}
	
	public String verifyEntrataMarketingAndLeasingProducts() {
		List<WebElement> MarketingAndLeasingProducts = driver.findElements(By.xpath(beforeXpath + "Marketing & Leasing" + afterXpath));
		String MarketingAndLeasingProductList = returnProductList(MarketingAndLeasingProducts);
		return MarketingAndLeasingProductList;
	}
	
	public String verifyEntrataAccountingProducts() {
		List<WebElement> AccountingProducts = driver.findElements(By.xpath(beforeXpath + "Accounting" + afterXpath));
		String AccountingProductList = returnProductList(AccountingProducts);
		return AccountingProductList;
	}
	
	public String verifyEntrataUtilitiesProducts() {
		List<WebElement> UtilitiesProducts = driver.findElements(By.xpath(beforeXpath + "Utilities" + afterXpath));
		String UtilitiesProductList = returnProductList(UtilitiesProducts);
		return UtilitiesProductList;
	}
	
	public String verifyEntrataAllSolutions() {
		actions.moveToElement(Solutions).build().perform();
		List<WebElement> AllSolutions = driver.findElements(By.xpath(beforeXpath + "All Solutions" + afterXpath));
		String allSolutionsList = returnProductList(AllSolutions);
		return allSolutionsList;
	}

}
