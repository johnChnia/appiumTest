package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.ModifySecurityCodePageObjects;

public class ModifySecurityCodePage extends CommonAppiumTest{

	ModifySecurityCodePageObjects modifySecurityCodePageObjects = new ModifySecurityCodePageObjects();
	public ModifySecurityCodePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				modifySecurityCodePageObjects);
	} 
	
	/**
	 * 
	 * @param oldPasswd
	 * @param newPasswd
	 * @return
	 */
	public SecuritySetPage setSecurityCode(String oldPasswd, String newPasswd) {
		typeSecurityCode(oldPasswd);
		typeSecurityCode(newPasswd);
		typeSecurityCode(newPasswd);
		return new SecuritySetPage(driver);
	}
	
	public ModifySecurityCodePage typeSecurityCode(String passwd) {
		waitForModifySecurityCodePage();
		inputSecurityPasswd(passwd);
		return this;
	}
	
	
	public ModifySecurityCodePage waitForModifySecurityCodePage() {
		waitForPageToLoad(modifySecurityCodePageObjects.edit_passwd);
		return this;
	}
	
	/**
	 * 
	 * @param passwd
	 */
	public void inputSecurityPasswd(String passwd) {
		modifySecurityCodePageObjects.edit_passwd.click();
		String[] str = passwd.split("");
		for (int j = 0; j < str.length; j++) {
			pressKeyCode(Integer.parseInt(str[j]) + 7);
		}
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
