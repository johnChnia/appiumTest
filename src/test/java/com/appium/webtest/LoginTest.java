package com.appium.webtest;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.WelcomePage;

import org.testng.annotations.Test;

public class LoginTest extends UserBaseTest {

	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void loginWithValidUser() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("13309300005", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(5)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage();
	}

}
