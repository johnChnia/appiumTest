package com.appium.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.TiXianPageObjects;
import com.appium.utils.DBUtil;

public class TiXianPage extends CommonAppiumTest{

	TiXianPageObjects tiXianPageObjects = new TiXianPageObjects();
	static Properties properties = new Properties();
	
	public TiXianPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				tiXianPageObjects);
	}

	public TiXianPage waitTixianPage() {
		waitForPageToLoad(tiXianPageObjects.liJiTiXianBtn);
		return this;
	}
	
	public TiXianPage tiXian(String loan, String mobile) {
		waitTixianPage();
		clickImmediateWithdrawal();
		inputLoan(loan);
		selectDate();
		clickConfirmBtn();
		inputOtpForTiXian(mobile);
		agreeAgreement();
		clickCommitBtn();
		return this;
	}
	
	public TiXianPage clickImmediateWithdrawal() {
		tiXianPageObjects.liJiTiXianBtn.click();
		return this;
	}
	
	public TiXianPage inputLoan(String loan) {
		waitForElement(tiXianPageObjects.edit_amount);
		tiXianPageObjects.edit_amount.clear();
		tiXianPageObjects.edit_amount.sendKeys(loan);
		return this;
	}

	public TiXianPage selectDate() {
		tiXianPageObjects.select_date.click();
		return this;
	}
	
	public TiXianPage clickConfirmBtn() {
		tiXianPageObjects.tixian_confirm_btn.click();
		return this;
	}
	
	public TiXianPage clickCommitBtn() {
		tiXianPageObjects.confirm_tixian_confirm_btn.click();
		return this;
	}
	
	public TiXianPage inputOtpForTiXian(String mobile) {
		waitForElement(tiXianPageObjects.getAuthCode);
		tiXianPageObjects.getAuthCode.click();
		try {
			TimeUnit.SECONDS.sleep(3);
			tiXianPageObjects.edit_otp.sendKeys(new LoanConfirmPage(driver).getOtpForConfirmLoan(mobile));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public TiXianPage agreeAgreement() {
		tiXianPageObjects.agree_agreement.click();
		return this;
	}
	
	public static void createLimitUsers(String mobile) {
		int userId = -1;
		try {
			properties.load(new FileInputStream("config.properties"));
			String sqlForTiXian = properties
					.getProperty("sqlForTiXian");
			String sqlForUserId = properties.getProperty("sqlForBorrowerId");
			DBUtil.getConnection("postgres");
			userId = (int) DBUtil.queryMap(sqlForUserId, mobile).get("id");
			DBUtil.execute(sqlForTiXian, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}
