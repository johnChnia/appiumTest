package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.ModifyGestureCodePageObjects;

public class ModifyGestureCodePage extends CommonAppiumTest{

	ModifyGestureCodePageObjects modifyGestureCodePageObjects = new ModifyGestureCodePageObjects();
	public ModifyGestureCodePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				modifyGestureCodePageObjects);
	}

	public ModifyGestureCodePage waitForModifyGestureCodePage() {
		waitForPageToLoad(modifyGestureCodePageObjects.head);
		return this;
	}
	
	public SecuritySetPage setGestureForSecurity() {
		new GesturesPage(driver).waitForGesturesForGesturesPage().setGestures().setGestures().setGestures();
		return new SecuritySetPage(driver);
	}
}
