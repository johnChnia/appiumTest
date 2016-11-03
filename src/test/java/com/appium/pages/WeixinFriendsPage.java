package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.WeixinFriendsPageObjects;

public class WeixinFriendsPage extends CommonAppiumTest{

	WeixinFriendsPageObjects weixinFriendsPageObjects = new WeixinFriendsPageObjects();
	public WeixinFriendsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), weixinFriendsPageObjects);
	}

	public WeixinFriendsPage waitForWeixinFriendsPage() {
		waitForPageToLoad(weixinFriendsPageObjects.search_editText);
		return this;
	}
	
	public SharePage share(String name) {
		waitForWeixinFriendsPage();
		sendTo(name);
		send();
		return backToSharePage();
	}
	
	public WeixinFriendsPage sendTo(String name) {
		weixinFriendsPageObjects.search_editText.sendKeys(name);
		waitForPageToLoad(weixinFriendsPageObjects.send_to);
		weixinFriendsPageObjects.send_to.click();
		return this;
	}
	
	public WeixinFriendsPage send() {
		weixinFriendsPageObjects.send_btn.click();
		return this;
	}
	
	public SharePage backToSharePage() {
		waitForPageToLoad(weixinFriendsPageObjects.back_to_sharePage);
		weixinFriendsPageObjects.back_to_sharePage.click();
		return new SharePage(driver);
	}
}
