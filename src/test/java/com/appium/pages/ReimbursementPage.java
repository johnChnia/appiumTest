package com.appium.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.ReimbursementPageObject;
import com.appium.utils.DBUtil;

public class ReimbursementPage extends CommonAppiumTest {

	static Properties properties = new Properties();
	ReimbursementPageObject reimbursementPageObjects = new ReimbursementPageObject();

	public ReimbursementPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				reimbursementPageObjects);
	}

	public ReimbursementPage noCardRepay(String passwd) {
		waitForReimbursementPage();
		clickRepayButton();
		waitForRepayWindow();
		typeSecurityPasswd(passwd);
		clickComfirmButton();
		// clickAlterButton();
		return this;
	}

	public ReimbursementPage cardRepay(String passwd) {
		waitForReimbursementPage();
		clickRepayButton();
		waitForRepayWindow();
		enterMyCardVolume().waitForMyCardVolume().userCard();
		waitForRepayWindow();
		typeSecurityPasswd(passwd);
		clickComfirmButton();
		// clickAlterButton();
		return this;
	}

	public ReimbursementPage AdvancePay(String passwd) {
		waitForReimbursementPage();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickRepayInAdvanceButton();
		waitForPayInAdvanceWindow();
		typeSecurityPasswd(passwd);
		clickRepayInAdvanceConfirmButton();
		// clickAlterButton();
		return this;
	}

	public ReimbursementPage waitForPayInAdvanceWindow() {
		waitForPageToLoad(reimbursementPageObjects.pay_in_advance_head);
		return this;
	}

	/**
	 * 可能需要修改
	 */
	public static void prepareForPayInAdvance(String mobile) {
		try {
			properties.load(new FileInputStream("config.properties"));
			String sqlForBorrowerId = properties
					.getProperty("sqlForBorrowerId");
			String sqlForUpdateDisbursed_at = properties
					.getProperty("sqlForUpdateDisbursed_at");
			DBUtil.getConnection("postgres");
			int borrower_id = (int) DBUtil.queryMap(sqlForBorrowerId, mobile).get("id");
			DBUtil.execute(sqlForUpdateDisbursed_at, borrower_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ReimbursementPage clickRepayInAdvanceButton() {
		reimbursementPageObjects.pay_in_advance.click();
		return this;
	}

	public ReimbursementPage clickRepayInAdvanceConfirmButton() {
		reimbursementPageObjects.pay_in_advance_confirm_btn.click();
		return this;
	}

	public ReimbursementPage waitForReimbursementPage() {
		waitForPageToLoad(reimbursementPageObjects.repay_btn);
		return this;
	}

	public ReimbursementPage clickRepayButton() {
		reimbursementPageObjects.repay_btn.click();
		return this;
	}

	public ReimbursementPage waitForRepayWindow() {
		waitForPageToLoad(reimbursementPageObjects.pwd_0);
		return this;
	}

	/**
	 * 普通的sendKeys方法不稳定，所以对安卓采用 adb inputKeyevent 方式输入
	 * 
	 * @param passwd
	 * @return
	 */
	public ReimbursementPage typeSecurityPasswd(String passwd) {
		inputComsumeInfo(passwd);
		return this;
	}

	public ReimbursementPage clickComfirmButton() {
		reimbursementPageObjects.comfirm_btn.click();
		return this;
	}

	public ReimbursementPage clickAlterButton() {
		waitForPageToLoad(reimbursementPageObjects.alter_confirm);
		reimbursementPageObjects.alter_confirm.click();
		return this;
	}

	public MyCardVolume enterMyCardVolume() {
		reimbursementPageObjects.use_cards.click();
		return new MyCardVolume(driver);
	}

	public void verify() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		backToMyLoanPage().enterReimbursementPage();
	}

	public void verifyForAdvancePay() {
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		backToMyLoanPage();
	}

	public MyLoan backToMyLoanPage() {
		clickBackButton();
		return new MyLoan(driver);
	}

	/**
	 * 
	 * @param passwd
	 */
	public void inputComsumeInfo(String passwd) {
		reimbursementPageObjects.pwd_0.click();
		String[] str = passwd.split("");
		for (int j = 0; j < str.length; j++) {
			pressKeyCode(Integer.parseInt(str[j]) + 7);
		}
	}
}
