package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.HomePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@PageName("HomePage")
public class HomePage extends CommonAppiumTest {

	HomePageObjects homePageObjects = new HomePageObjects();

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				homePageObjects);
	}

	public LoanConfirmPage applyLoan(String loanCount) {
		waitForHomePage();
		selectLoanAmount(loanCount);
		selectLoanTime();
		return submitApply();
	}

	/**
	 * 
	 * @param loanCount
	 *   贷款金额
	 * @return
	 */
	public PersonalInformationPage applyLoanForNewUser(String loanCount) {
//		selectIdentity();
		waitForHomePage();
		selectLoanAmount(loanCount);
		selectLoanTime();
		return submitApplyForNewUser();
	}

	public HomePage selectIdentity() {
		waitForElement(homePageObjects.identity_gx);
		homePageObjects.identity_gx.click();
		waitForElement(homePageObjects.identity_confirm_btn);
		homePageObjects.identity_confirm_btn.click();
		return this;
	}
	
	public HomePage waitForHomePage() {
		waitForPageToLoad(homePageObjects.apply_btn);
		return this;
	}

	public HomePage selectLoanAmount(String loanCount) {
		if (Integer.valueOf(loanCount) > 3000) {
			homePageObjects.apply_amount.setValue(loanCount);
		} else {
			homePageObjects.apply_amount.clear();
		}
		return this;
	}

	public HomePage selectLoanTime() {
		homePageObjects.loan_time.click();
		return this;
	}

	public LoanConfirmPage submitApply() {
		homePageObjects.apply_btn.click();
		return new LoanConfirmPage(driver);
//		return new ContactInfoPage(driver);
	}

	public PersonalInformationPage submitApplyForNewUser() {
		homePageObjects.apply_btn.click();
		return new PersonalInformationPage(driver);
	}

	public AccountPage enterAccountPage() {
		homePageObjects.account.click();
		return new AccountPage(driver);
	}

	public MorePage enterMorePage() {
		homePageObjects.more.click();
		return new MorePage(driver);
	}

	public LoanConfirmPage enterLoanConfirmPage() {
		enterAccountPage().waitForAccountPage().enterMyLoan();
		waitForElement(homePageObjects.approve_confirm);
		homePageObjects.approve_confirm.click();
		return new LoanConfirmPage(driver);
	}
	
	/**
	 * 进入提现页面
	 * @return
	 */
	public TiXianPage enterTiXianPage() {
		waitForElement(homePageObjects.tiXian);
		homePageObjects.tiXian.click();
		return new TiXianPage(driver);
	}
}
