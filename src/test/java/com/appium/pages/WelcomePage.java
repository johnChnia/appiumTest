package com.appium.pages;


import java.util.concurrent.TimeUnit;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@PageName("WelcomePage")
public class WelcomePage extends CommonAppiumTest{

	public WelcomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 * 默认等待3s
	 */
	public WelcomePage waitForWelcomePage() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		return new WelcomePage(driver);
	}
	/***
	 * 
	 * @param count		向左滑动次数
	 * @return
	 * @throws InterruptedException
	 */
	public LoginPage swipeLeftToLoginPage(int count) throws InterruptedException {
		for (int i = 0; i < count; i++) {
			swipeLeft();
		}
		return new LoginPage(driver);
	}
	
}
