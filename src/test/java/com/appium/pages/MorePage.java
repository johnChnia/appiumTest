package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.MorePageObjects;

public class MorePage extends CommonAppiumTest{

	MorePageObjects morePageObjects = new MorePageObjects();
	
	public MorePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				morePageObjects);
	}

	public MorePage waitForMorePage() {
		waitForPageToLoad(morePageObjects.about_us);
		return this;
	}
	
	public MorePage logOut() {
		waitForMorePage();
		morePageObjects.log_out.click();
		morePageObjects.confirm_log_out.click();
		return this;
	}
	
	public GuidePage enterGuidePage() {
		waitForMorePage();
		morePageObjects.guide.click();
		return new GuidePage(driver);
	}
	
	public SecurityPage enterSecurityPage() {
		morePageObjects.security_btn.click();
		return new SecurityPage(driver);
	}
	
	public MorePage checkUpdate() {
		waitForMorePage();
		morePageObjects.check_update.click();
		clickBackButton(); //临时处理
		return this;
	}
	
	public MorePage enterAboutUsPage() {
		try {
			morePageObjects.about_us.click();
			Thread.sleep(2000);
			clickBackButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
}
