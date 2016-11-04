package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.WelcomePage;

public class SecurityTest extends UserBaseTest {
	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void loginWithValidUser() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("18610246662", "888888");
		 welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
		 .setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(5)
		 .loginAs(user.getUserName(), user.getPassWord())
		 .setGesturesForGesturesPage().waitForHomePage()
		 .enterAccountPage().waitForAccountPage().enterSecuritySetPage()
		 .waitForSecuritySetPage().enterModifySecurityCodePage()
		 .waitForModifySecurityCodePage()
		 .setSecurityCode("123456", "123456");

//		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
//				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(5)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage().waitForHomePage()
//				.enterAccountPage().waitForAccountPage().enterSecuritySetPage()
//				.waitForSecuritySetPage().enterModifyGestureCodePage()
//				.waitForModifyGestureCodePage().setGestureForSecurity();
	}
}
