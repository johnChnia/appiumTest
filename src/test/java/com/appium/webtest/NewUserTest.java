package com.appium.webtest;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.LoanConfirmPage;
import com.appium.pages.ReimbursementPage;
import com.appium.pages.WelcomePage;
import com.appium.utils.IdCardGenerator;

public class NewUserTest extends UserBaseTest {
	User user;
	WelcomePage welcomePage;


//	@Test(groups = "applyLoan")
//	@Author(name = "john")
//	public void NewUserApplyLoan() throws Exception {
//		user = new User("18610241122", "888888");
//		welcomePage = new WelcomePage(driver);
//		
//		welcomePage
//				.waitForWelcomePage()
//				.swipeLeftToLoginPage(5)
//				.setEnvironment()
//				.waitForWelcomePage()
//				.swipeLeftToLoginPage(7)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage()
//				.applyLoanForNewUser("8000")
//				.fillPersonalInfor("周志鹏")
//				.fillWorkUnit()
//				.fillCreditInfo("6217002950000161321", user.getUserName(),
//						"12000").fillContactInfo()
//				.fillPhotoCertification(user.getUserName())
//				.enterLoanConfirmByPhotoCertyPage()
//				.submitLoanApply(user.getUserName());
//	}
//
//	@Test(groups = "confirmLoan")  
//	@Author(name = "john")
//	public void NewUserConfirm() throws InterruptedException {
//		user = new User("18610241122", "888888");
//		welcomePage = new WelcomePage(driver);
//		
//		//审批
//		LoanConfirmPage.approval(user.getUserName());
//
//		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
//				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage().enterLoanConfirmPage()
//				.bindBankCard("6217002950000161321").confirmLoanForNewUser(user.getUserName(), "111111");
//	}
	
//	@Test(groups = "repayNoCard")
//	@Author(name = "john")
//	public void noCardRepayTest() throws InterruptedException {
//		user = new User("18610241122", "888888");
//		welcomePage = new WelcomePage(driver);
//		
//		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
//				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
//				.loginAs(user.getUserName(), user.getPassWord())
//				.setGesturesForGesturesPage().waitForHomePage()
//				.enterAccountPage().waitForAccountPage().enterMyLoan()
//				.enterReimbursementPage().noCardRepay("111111");
//	}

	@Test(groups = "repayCard")
	@Author(name = "john")
	public void cardRepayTest() throws InterruptedException {
		user = new User("18610241122", "888888");
		welcomePage = new WelcomePage(driver);
		
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage()
				.enterAccountPage().waitForAccountPage().enterMyLoan()
				.enterReimbursementPage().waitForReimbursementPage()
				.cardRepay("111111");
	}
//
	@Test(groups = "advanceRepay", dependsOnGroups = "repayCard", alwaysRun = true)
	@Author(name = "john")
	public void advanceRepayTest() throws InterruptedException {
		
		user = new User("18610241122", "888888");
		welcomePage = new WelcomePage(driver);
		
		
		// 提前还清数据库操作
		ReimbursementPage.prepareForPayInAdvance(user.getUserName());

		TimeUnit.SECONDS.sleep(2);

		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage()
				.enterAccountPage().enterMyLoan().enterReimbursementPage()
				.AdvancePay("111111");
	}
}
