package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.WelcomePage;

public class QQZoneTest extends UserBaseTest{
	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void loginWithValidUser() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("15000806417", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(7)
		.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
		.loginAs(user.getUserName(), user.getPassWord())
		.setGesturesForGesturesPage().waitForHomePage()
		.enterAccountPage().waitForAccountPage().enterSharePage().waitForSharePage().shareByQQZone().share();
	}
}
