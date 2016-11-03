package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.SecuritySetPageObjects;

public class SecuritySetPage extends CommonAppiumTest{

	SecuritySetPageObjects securitySetPageObject = new SecuritySetPageObjects();
	
	public SecuritySetPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				securitySetPageObject);
	}
	
	public SecuritySetPage waitForSecuritySetPage() {
		waitForPageToLoad(securitySetPageObject.modify_gesture_code);
		return this;
	}
	
	public ModifySecurityCodePage enterModifySecurityCodePage() {
		waitForSecuritySetPage();
		securitySetPageObject.modify_security_code.click();
		return new ModifySecurityCodePage(driver);
	}
	
	public ModifyGestureCodePage enterModifyGestureCodePage() {
		waitForSecuritySetPage();
		securitySetPageObject.modify_gesture_code.click();
		return new ModifyGestureCodePage(driver);
	}
	
	public AccountPage backToAccountPage() {
		waitForSecuritySetPage();
		clickBackButton();
		return new AccountPage(driver);
	}
	
}
