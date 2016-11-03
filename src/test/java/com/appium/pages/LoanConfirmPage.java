package com.appium.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.LoanConfirmPageObjects;
import com.appium.utils.DBUtil;
import com.appium.utils.InputMethodUtil;

@PageName("LoanConfirmPage")
public class LoanConfirmPage extends CommonAppiumTest {

	static Properties properties = new Properties();
	LoanConfirmPageObjects loanConfirmObjects = new LoanConfirmPageObjects();
	InputMethodUtil ime = new InputMethodUtil(); // 切换输入法，手动输入 OTP

	public LoanConfirmPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				loanConfirmObjects);
	}

	public LoanConfirmPage waitForLoanConfirmPage() {
		waitForPageToLoad(loanConfirmObjects.loanConfirm_text);
		return this;
	}

	public HomePage confirmLoan(String mobile) throws InterruptedException {
		waitForLoanConfirmPage();
		swipeUp();
		getCode();
		InputOtpForConfrim(mobile);
		selectedCheckBox();
		commitLoanApprovl();
		return clickLoanComfirmQueDing();
	}

	

	/**
	 * 
	 * @param mobile
	 *     手机号码
	 * @param passwd
	 *     安全密码
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage confirmLoanForNewUser(String mobile, String passwd) throws InterruptedException {
		waitForLoanConfirmPage();
		swipeUp();
		getCode();
		InputOtpForConfrim(mobile);
		selectedCheckBox();
		commitLoanApprovl();
		setSecrityPasswd(passwd);
		return clickLoanComfirmQueDing();
	}
	
	public LoanConfirmPage bindBankCard(String bankCard) {
		waitForLoanConfirmPage();
		return enterBindBankCardPage().bindBankCardOneStep(bankCard)
				.bindBankCardTwoStep().bindBankCardThreeStep();
	}

	public HomePage clickLoanComfirmQueDing() {
		waitForPageToLoad(loanConfirmObjects.loanComfirm_queding_btn);
		loanConfirmObjects.loanComfirm_queding_btn.click();
		return new HomePage(driver);
	}

	public HomePage clickApplyLoanQueDing() {
		waitForPageToLoad(loanConfirmObjects.applyLoan_queding_btn);
		loanConfirmObjects.applyLoan_queding_btn.click();
		return new HomePage(driver);
	}

	public LoanConfirmPage getCode() {
		waitForElement(loanConfirmObjects.confirm_get_code_btn);
		loanConfirmObjects.confirm_get_code_btn.click();
		return this;
	}

	public LoanConfirmPage sendCode() throws InterruptedException {
		ime.enableLatinIME();
		TimeUnit.SECONDS.sleep(8);
		ime.enableAppiumUnicodeIME();
		return this;
	}

	public LoanConfirmPage selectedCheckBox() {
		loanConfirmObjects.confirm_checkbox.click();
		return this;
	}

	public LoanConfirmPage commitLoanApprovl() {
		loanConfirmObjects.confirm_commit_btn.click();
		return this;
	}

	public HomePage submitLoanApply(String mobile) throws InterruptedException {
		swipeUpUntilTextExists("提交申请");
		checkAgree();
		getCode();
		InputOtpForApply(mobile);
		submitCommit();
		TimeUnit.SECONDS.sleep(3);
		clickApplyLoanQueDing();
		return new HomePage(driver);
	}

	public LoanConfirmPage InputOtpForApply(String mobile) {
		try {
			TimeUnit.SECONDS.sleep(3);
			loanConfirmObjects.edt_otp
					.sendKeys(getOtpForApply(mobile));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public LoanConfirmPage InputOtpForConfrim(String mobile) {
		try {
			TimeUnit.SECONDS.sleep(3);
			loanConfirmObjects.edt_otp
					.sendKeys(getOtpForConfirmLoan(mobile));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public LoanConfirmPage checkAgree() {
		loanConfirmObjects.check_btn.click();
		return this;
	}

	public HomePage submitCommit() {
		loanConfirmObjects.commit_btn.click();
		return new HomePage(driver);
	}

	public BindBankCardPage enterBindBankCardPage() {
		waitForElement(loanConfirmObjects.enter_bind_bank);
		loanConfirmObjects.enter_bind_bank.click();
		return new BindBankCardPage(driver);
	}
	
	public void setSecrityPasswd(String passwd) {
		ModifySecurityCodePage msc = new ModifySecurityCodePage(driver);
		msc.typeSecurityCode(passwd);
		loanConfirmObjects.nextStep.click();
		msc.typeSecurityCode(passwd);
		loanConfirmObjects.confirm_set_btn.click();
	}

	/**
	 * 审批平台审批
	 * 
	 * @return
	 */
	public static void approval(String mobile) {
		try {
			properties.load(new FileInputStream("config.properties"));
			String sqlForUpdate_loanApplications = properties
					.getProperty("sqlForUpdate_loanApplications");
			String sqlForBorrowerId = properties
					.getProperty("sqlForBorrowerId");
			String sqlForApplications_id = properties
					.getProperty("sqlForApplications_id");
			String sqlForApproval_history = properties
					.getProperty("sqlForApproval_history");
			DBUtil.getConnection("postgres");
			int borrower_id = (int) DBUtil.queryMap(sqlForBorrowerId, mobile)
					.get("id");
			String applications_id = (String) DBUtil.queryMap(
					sqlForApplications_id, borrower_id).get("application_id");
			DBUtil.execute(sqlForUpdate_loanApplications, applications_id);
			DBUtil.execute(sqlForApproval_history, applications_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getOtpForApply(String mobile) {
		String otp = null;
		try {
			properties.load(new FileInputStream("config.properties"));
			String sqlForGetOtp_apply = properties
					.getProperty("sqlForGetOtp_apply");
			DBUtil.getConnection("postgres");
			otp = (String) DBUtil.queryMap(sqlForGetOtp_apply, mobile).get(
					"code");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;
	}
	
	public String getOtpForConfirmLoan(String mobile) {
		String otp = null;
		try {
			properties.load(new FileInputStream("config.properties"));
			String sqlForGetOtp_apply = properties
					.getProperty("sqlForGetOtp_confirm");
			DBUtil.getConnection("postgres");
			otp = (String) DBUtil.queryMap(sqlForGetOtp_apply, mobile).get(
					"challengecode");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return otp;
	}
}
