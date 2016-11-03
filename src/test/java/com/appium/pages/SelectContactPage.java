package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.SelectContactPageObject;

public class SelectContactPage extends CommonAppiumTest{

	SelectContactPageObject selectContactPageObj = new SelectContactPageObject();
	public SelectContactPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), selectContactPageObj);
	}

	public SelectContactPage waitForSelectContactPage() {
		waitForPageToLoad(selectContactPageObj.waitSelectContactPage);
		return this;
	}
	
	public MyContactPage selectContact(String type) {
		waitForSelectContactPage();
		if (type.equalsIgnoreCase("colleagues")) {
			swipeUpUntilTextExists("张三");
			selectContactPageObj.select_colleagues.click();
		} else if (type.equalsIgnoreCase("friends")) {
			swipeUpUntilTextExists("李四");
			selectContactPageObj.select_friends.click();
		}
		return new MyContactPage(driver);
	}
	
}
