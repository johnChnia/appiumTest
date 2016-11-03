package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.BindBankCardPageObject;

public class BindBankCardPage extends CommonAppiumTest {

	BindBankCardPageObject bindBankCardObj = new BindBankCardPageObject();

	public BindBankCardPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				bindBankCardObj);
	}

	public BindBankCardPage bindBankCardOneStep(String bankCard) {
		inputBankCard(bankCard);
		clickbindBankCardBtn();
		clickNextStepBtn();
		return this;
	}
	
	public BindBankCardPage bindBankCardTwoStep() {
		inputVerificationCode();
		inputPayPasswd();
		clickConfirmBtn();
		clickNextStepBtn();
		return this;
	}

	/**
	 * 虽然代码有冗余，但是给人看的感觉更加直观，清楚
	 * @return
	 */
	public LoanConfirmPage bindBankCardThreeStep() {
		inputVerificationCode();
		inputPayPasswd();
		clickConfirmBtn();
		clickNextStepBtn();
		return new LoanConfirmPage(driver);
	}
	
	public BindBankCardPage inputBankCard(String bankCard) {
		waitForPageToLoad(bindBankCardObj.input_bankCard);
		bindBankCardObj.input_bankCard.sendKeys(bankCard);
		return this;
	}

	public BindBankCardPage clickbindBankCardBtn() {
		bindBankCardObj.bind_bankCard_btn.click();
		return this;
	}
	
	public BindBankCardPage clickNextStepBtn() {
		waitForElement(bindBankCardObj.next_step_btn);
		bindBankCardObj.next_step_btn.click();
		return this;
	}
	
	public BindBankCardPage inputVerificationCode() {
		waitForPageToLoad(bindBankCardObj.get_verification_code);
		bindBankCardObj.get_verification_code.click();
		bindBankCardObj.edit_verification_code.sendKeys("1234");
		return this;
	}
	
	public BindBankCardPage clickConfirmBtn() {
		bindBankCardObj.confirm_btn.click();
		return this;
	}
	
	public BindBankCardPage inputPayPasswd() {
		bindBankCardObj.edit_pay_passwd.sendKeys("123456");
		return this;
	}
}
