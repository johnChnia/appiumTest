package com.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import com.appium.config.CommonAppiumTest;

public class GuidePage extends CommonAppiumTest{

	public GuidePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public GuidePage waitForGuidePage() throws InterruptedException {
		Thread.sleep(3000);
		return this;
	}
	
	public MorePage flow() throws InterruptedException {
		waitForGuidePage();
		new WelcomePage(driver).swipeLeftToLoginPage(3);
		return new MorePage(driver);
	}
}
