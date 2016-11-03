package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.SharePageObjects;

public class SharePage extends CommonAppiumTest{

	SharePageObjects sharePageObjects = new SharePageObjects();
	public SharePage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), sharePageObjects);
	}

	public SharePage waitForSharePage() throws InterruptedException {
		waitForElement(sharePageObjects.share_now);;
		return this;
	}
	
	public SharePage OpenShareList() throws InterruptedException {
		waitForSharePage();
		sharePageObjects.share_now.click();
		return this;
	}
	
	public WeiBoPage shareByWeiBo() throws InterruptedException {
		OpenShareList();
		sharePageObjects.share_sina_btn.click();
		return new WeiBoPage(driver);
	}
	
	public QQPage shareByQQ() throws InterruptedException {
		OpenShareList();
		sharePageObjects.share_qq_btn.click();
		return new QQPage(driver);
	}
	
	public QQZonePage shareByQQZone() throws InterruptedException {
		OpenShareList();
		sharePageObjects.share_zone_btn.click();
		return new QQZonePage(driver);
	}
	
	public FriendsCirlePage shareByFriendsCirle() throws InterruptedException {
		OpenShareList();
		sharePageObjects.share_circle_btn.click();
		return new FriendsCirlePage(driver);
	}
	
	public WeixinFriendsPage shareByWeiXinFriends() throws InterruptedException {
		OpenShareList();
		sharePageObjects.share_friends_btn.click();
		return new WeixinFriendsPage(driver);
	}
	
	public AccountPage backToAccountPage() throws InterruptedException {
		waitForSharePage();
		clickBackButton();
		swipeUp();
		return new AccountPage(driver);
	}
}
