package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.AccountPageObjects;

public class AccountPage extends CommonAppiumTest{

	AccountPageObjects accountPageObjects = new AccountPageObjects();
	
	public AccountPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				accountPageObjects);
	}

	public AccountPage waitForAccountPage() {
		waitForPageToLoad(accountPageObjects.redeem_code);
		return this;
	}
	
	public RedeemPage enterRedeemPage() {
		waitForAccountPage();
		accountPageObjects.redeem_code.click();
		return new RedeemPage(driver);
	}
	
	public SecuritySetPage enterSecuritySetPage() {
		waitForAccountPage();
		swipeUp();
		accountPageObjects.security_set.click();
		return new SecuritySetPage(driver);
	}
	
	public SharePage enterSharePage() {
		waitForAccountPage();
		accountPageObjects.bonus_share.click();
		return new SharePage(driver);
	}
	
	public MyLoan enterMyLoan() {
		waitForAccountPage();
		accountPageObjects.my_loan.click();
		return new MyLoan(driver);
	}
	
	public MyCardVolume enterMyCardVolume() {
		waitForAccountPage();
		accountPageObjects.my_cardVolume.click();
		return new MyCardVolume(driver);
	}
	
	public HomePage backToHomePage() {
		waitForAccountPage();
		clickBackButton();
		return new HomePage(driver);
	}
	
}


