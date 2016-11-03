package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.WeiBoPageObjects;

public class WeiBoPage extends CommonAppiumTest{

	WeiBoPageObjects weiBoPageObjects = new WeiBoPageObjects();
	public WeiBoPage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), weiBoPageObjects);

	}

	public WeiBoPage waitForWeiBoPage() {
		waitForPageToLoad(weiBoPageObjects.write_content);
		return this;
	}
	public SharePage share() {
		waitForWeiBoPage();
		weiBoPageObjects.write_content.sendKeys("AutomatorTest");
		weiBoPageObjects.send_btn.click();
		return new SharePage(driver);
	}
	
}
