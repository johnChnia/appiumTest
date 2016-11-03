package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.MyCardVolumeObjects;

public class MyCardVolume extends CommonAppiumTest{

	MyCardVolumeObjects myCardsVolumeObjects = new MyCardVolumeObjects();
	public MyCardVolume(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				myCardsVolumeObjects);
	}

	public ReimbursementPage userCard() {
		myCardsVolumeObjects.bonus_item_root.click();
		myCardsVolumeObjects.use_btn.click();
		return new ReimbursementPage(driver);
	}
	
	public MyCardVolume waitForMyCardVolume() {
		waitForPageToLoad(myCardsVolumeObjects.use_rule);
		return this;
	}
	
	public AccountPage lookUserRule() {
		waitForMyCardVolume();
		myCardsVolumeObjects.use_rule.click();
		waitForElement(myCardsVolumeObjects.wait_look_rule);  // 因为网络原因加的
		clickBackButton();
		waitForPageToLoad(myCardsVolumeObjects.use_rule);
		clickBackButton();
		return new AccountPage(driver);
	}
	
}
