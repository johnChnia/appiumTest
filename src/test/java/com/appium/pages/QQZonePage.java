package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.QQZoneObjects;

public class QQZonePage extends CommonAppiumTest{

	QQZoneObjects qqZoneObjects = new QQZoneObjects();
	public QQZonePage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), qqZoneObjects);
	}

	public QQZonePage waitForQQZonePage() {
		waitForPageToLoad(qqZoneObjects.send_btn);
		return this;
	}
	public SharePage share() throws InterruptedException {
		waitForQQZonePage();
		send();
		Thread.sleep(2000);
		return new SharePage(driver);
	}
	public QQZonePage send() {
		qqZoneObjects.send_btn.click();
		return this;
	}
	
}
