package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.LoanConfirmPage;
import com.appium.pages.WelcomePage;

public class LoanConfirmTest extends UserBaseTest{
	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void loanConfirmTest1() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("18627666666", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
		.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(5)
		.loginAs(user.getUserName(), user.getPassWord())
		.setGesturesForGesturesPage().waitForHomePage()
		.enterLoanConfirmPage().confirmLoan("18627666666");
	}
}
