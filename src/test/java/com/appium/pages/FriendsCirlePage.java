package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import gherkin.lexer.Fr;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.FriendsCirclePageObjects;

public class FriendsCirlePage extends CommonAppiumTest{

	FriendsCirclePageObjects friendsCirclePageObjects = new FriendsCirclePageObjects();
	public FriendsCirlePage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), friendsCirclePageObjects);
	}

	public FriendsCirlePage waitForFriendsCirlePage() {
		waitForPageToLoad(friendsCirclePageObjects.send_btn);
		return this;
	}
	
	public SharePage share() {
		waitForFriendsCirlePage();
		return send();
	}
	
	public SharePage send() {
		friendsCirclePageObjects.send_btn.click();
		return new SharePage(driver);
	}
}
