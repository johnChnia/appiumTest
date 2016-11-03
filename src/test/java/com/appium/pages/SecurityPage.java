package com.appium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.SecurityPageObjects;

public class SecurityPage extends CommonAppiumTest{

	SecurityPageObjects securityPageObjects = new SecurityPageObjects();
	public SecurityPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				securityPageObjects);
	}

	public SecurityPage waitForSecurityPage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * 该方法在 appium1.5.3上不支持，请注意
	 * @return
	 */
	public SecurityPage enterProfessionalPage() {
		setContext();
		securityPageObjects.professional.click();
		return this;
	}
}
