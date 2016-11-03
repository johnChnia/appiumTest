package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.LoanConfirmPage;
import com.appium.pages.WelcomePage;

public class ApplyLoanTest extends UserBaseTest {
	User user;
	WelcomePage welcomePage;

	@Test(groups = "smoke")
	@Author(name = "john")
	public void applyLoanTest() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("13309300002", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(5)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage().applyLoan("3000")
				.waitForLoanConfirmPage().submitLoanApply("13309300002");
		//审批平台审批
		LoanConfirmPage.approval("13309300002");
	}
}
