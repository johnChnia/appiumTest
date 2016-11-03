package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.QQPageObjects;

public class QQPage extends CommonAppiumTest{

	QQPageObjects qqPageObjects = new QQPageObjects();
	public QQPage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), qqPageObjects);

	}
	
	public QQPage waitForQQPage() {
		waitForPageToLoad(qqPageObjects.sendTo);
		return this;
	}
	public SharePage share() {
		waitForQQPage();
		selectSendTo();
		send();
		return backSharePage();
	}

	public QQPage selectSendTo() {
		qqPageObjects.sendTo.click();
		return this;
	}
	
	public QQPage send() {
		qqPageObjects.send_btn.click();
		return this;
	}
	
	public SharePage backSharePage() {
		qqPageObjects.back_to_sharePage.click();
		return new SharePage(driver);
	}
}
