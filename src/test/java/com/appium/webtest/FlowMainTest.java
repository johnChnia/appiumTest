package com.appium.webtest;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.annotation.values.SkipIf;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.LoanConfirmPage;
import com.appium.pages.ReimbursementPage;
import com.appium.pages.WelcomePage;

/**
 * 登录 → 进件 → 确认贷款 → 还款
 * 
 * @author john
 * @data 2016年10月9日
 */

public class FlowMainTest extends UserBaseTest {
//
	@Test(groups = "applayLoan")
	@Author(name = "john")
	public void applyLoanTest() throws InterruptedException {
		WelcomePage welcomePage = new WelcomePage(driver);
		User user = new User("18610246662", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage().applyLoan("3000")
				.waitForLoanConfirmPage().submitLoanApply(user.getUserName());
	}

	@Test(groups = "loanConfirm")
	@Author(name = "john")
	public void loanConfirmTest() throws InterruptedException {
		// 审批平台审批
		 LoanConfirmPage.approval("18610246662");

		WelcomePage welcomePage = new WelcomePage(driver);
		User user = new User("18610246662", "888888");
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage()
				.enterLoanConfirmPage().confirmLoan(user.getUserName());
	}

//	@Test(groups = "repayNoCard")
//	@Author(name = "john")
//	public void noCardRepayTest() throws InterruptedException {
//		WelcomePage welcomePage = new WelcomePage(driver);
//		User user = new User("18610246662", "888888");
//		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
//				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage().waitForHomePage()
//				.enterAccountPage().waitForAccountPage().enterMyLoan()
//				.enterReimbursementPage().noCardRepay("111111");
//	}
//
//	@Test(groups = "repayCard", dependsOnGroups = "repayNoCard")
//	@Author(name = "john")
//	public void cardRepayTest() throws InterruptedException {
//		WelcomePage welcomePage = new WelcomePage(driver);
//		User user = new User("18610246662", "888888");
//		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
//				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage().waitForHomePage()
//				.enterAccountPage().waitForAccountPage().enterMyLoan()
//				.enterReimbursementPage().waitForReimbursementPage()
//				.cardRepay("111111");
//	}
//
//	@Test(groups = "advanceRepay", dependsOnGroups = "repayCard", alwaysRun = true)
//	@Author(name = "john")
//	public void advanceRepayTest() throws InterruptedException {
//		// 提前还清数据库操作
//		ReimbursementPage.prepareForPayInAdvance("18610246662");
//
//		TimeUnit.SECONDS.sleep(2);
//
//		WelcomePage welcomePage = new WelcomePage(driver);
//		User user = new User("18610246662", "888888");
//		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
//				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage().waitForHomePage()
//				.enterAccountPage().enterMyLoan().enterReimbursementPage()
//				.AdvancePay("111111");
//	}
}
