package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.RedeemPage;
import com.appium.pages.WelcomePage;

public class RedeemTest extends UserBaseTest {
	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void loginWithValidUser() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("13309300001", "888888");
		String duiHuanMa = RedeemPage.produceCode();
		
		
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage()
				.enterAccountPage().waitForAccountPage().enterRedeemPage()
				.exchange(duiHuanMa).backToHomePage();
	}
}
