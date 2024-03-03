package com.entrata.utilities;
import java.lang.reflect.Method;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListener implements WebDriverListener {
	@Override
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Typing in an Element: " + element + " entered the value as: ");
		for(int i=0; i<keysToSend.length; i++) {
			System.out.println(keysToSend[i] + " ");
		}
		WebDriverListener.super.afterSendKeys(element, keysToSend);
	}
	@Override
	public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result) {
		System.out.println("Alert is: " + alert + "Method is: " + method + ". Result is: " + result);
		WebDriverListener.super.afterAnyAlertCall(alert, method, args, result);
	}
	@Override
	public void afterAccept(Alert alert) {
		System.out.println("Alert is: " + alert);
		WebDriverListener.super.afterAccept(alert);
	}
	@Override
	public void beforeClick(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeClick(element);
	}
	@Override
	public void beforeSubmit(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeSubmit(element);
	}
	@Override
	public void afterSubmit(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.afterSubmit(element);
	}
	@Override
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("WebElement is: " + element + ". keysToSend...: " + keysToSend);
		WebDriverListener.super.beforeSendKeys(element, keysToSend);
	}
	@Override
	public void beforeClear(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeClear(element);
	}
	@Override
	public void afterClear(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.afterClear(element);
	}
	@Override
	public void beforeGetTagName(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeGetTagName(element);
	}
	@Override
	public void afterGetTagName(WebElement element, String result) {
		System.out.println("WebElement is: " + element + ". Result: " + result);
		WebDriverListener.super.afterGetTagName(element, result);
	}
	@Override
	public void beforeGetAttribute(WebElement element, String name) {
		System.out.println("WebElement is: " + element + ". name: " + name);
		WebDriverListener.super.beforeGetAttribute(element, name);
	}
	@Override
	public void beforeFindElement(WebElement element, By locator) {
		System.out.println("WebElement is: " + element + ". Located by: " + locator);
		WebDriverListener.super.beforeFindElement(element, locator);
	}
	@Override
	public void afterFindElement(WebElement element, By locator, WebElement result) {
		System.out.println("WebElement is: " + element + ". Located by: " + locator + "Found WebElement : " + result);
		WebDriverListener.super.afterFindElement(element, locator, result);
	}
	@Override
	public void beforeIsDisplayed(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeIsDisplayed(element);
	}
	@Override
	public void afterIsDisplayed(WebElement element, boolean result) {
		System.out.println("WebElement is: " + element + ". Result: " + result);
		WebDriverListener.super.afterIsDisplayed(element, result);
	}
	@Override
	public void beforeGetLocation(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeGetLocation(element);
	}
	@Override
	public void afterGetLocation(WebElement element, Point result) {
		System.out.println("WebElement is: " + element + ". Result: " + result);
		WebDriverListener.super.afterGetLocation(element, result);
	}
	@Override
	public void beforeGetSize(WebElement element) {
		System.out.println("WebElement is: " + element);
		WebDriverListener.super.beforeGetSize(element);
	}
	@Override
	public void afterGetSize(WebElement element, Dimension result) {
		System.out.println("WebElement is: " + element + ". Result: " + result);
		WebDriverListener.super.afterGetSize(element, result);
	}
	@Override
	public void beforeGetCssValue(WebElement element, String propertyName) {
		System.out.println("WebElement is: " + element + ". propertyName: " + propertyName);
		WebDriverListener.super.beforeGetCssValue(element, propertyName);
	}
	@Override
	public void afterGet(WebDriver driver, String url) {
		System.out.println("Navigated to: " + url);
		WebDriverListener.super.afterGet(driver, url);
	}
	@Override
	public void afterQuit(WebDriver driver) {
		System.out.println("Test Execution Completed");
		WebDriverListener.super.afterQuit(driver);
	}
	@Override
	public void afterClick(WebElement element) {
		System.out.println("Clicking on an Element: " + element);
		WebDriverListener.super.afterClick(element);
	}
	@Override
	public void afterSendKeys(Alert alert, String text) {
		System.out.println("Typing text is: " + text);
		WebDriverListener.super.afterSendKeys(alert, text);
	}
}
