package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.ReimbursementPage;
import com.appium.pages.WelcomePage;

public class NoCardPayTest extends UserBaseTest{
	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void noCardRepayTest() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("13309300005", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(5)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage()
				.enterAccountPage().waitForAccountPage().enterMyLoan()
				.enterReimbursementPage().waitForReimbursementPage()
				.noCardRepay("111111");
	}
}
