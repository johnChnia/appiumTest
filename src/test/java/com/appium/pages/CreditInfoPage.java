package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.config.NewUserIdentify;
import com.appium.page.objects.CreditInfoPageObject;

public class CreditInfoPage extends CommonAppiumTest {

	CreditInfoPageObject creditInfoObj = new CreditInfoPageObject();

	public CreditInfoPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				creditInfoObj);
	}

	public CreditInfoPage waitForCreditInfoPage() {
		waitForElement(creditInfoObj.card_auth);
		return this;
	}

	/**
	 * 
	 * @param cardNum
	 * @param mobile
	 */
	public ContactInfoPage fillCreditInfo(String cardNum, String mobile,
			String loanCount) {
		enterCardAuthPage().fillCardAuthorization(cardNum);
		if (Integer.valueOf(loanCount) > 10000) {
			fillPayWaterByInterface(mobile);
		}
		clickNextButton();
		return new ContactInfoPage(driver);
	}

	public CardAuthPage enterCardAuthPage() {
		waitForCreditInfoPage();
		creditInfoObj.card_auth.click();
		return new CardAuthPage(driver);
	}

	/**
	 * 进入联系人信息Page
	 * 
	 * @return
	 */
	public ContactInfoPage clickNextButton() {
		waitForElement(creditInfoObj.next_btn);
		creditInfoObj.next_btn.click();
		return new ContactInfoPage(driver);
	}

	/**
	 * 工资卡流水, 由于网络问题，所以采取递归调用
	 * 
	 * @param mobile
	 * @return
	 */
	public CreditInfoPage fillPayWaterByInterface(String mobile) {
		NewUserIdentify nui = new NewUserIdentify();
		try {
			nui.identifyPost(mobile, "bank_card_transaction_flow_proof");
			freshForPayWater();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			fillPayWaterByInterface(mobile);
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public CreditInfoPage freshForPayWater() throws InterruptedException {

		TimeUnit.SECONDS.sleep(2);
		if (!driver.getPageSource().contains("工资卡流水")) {
			swipeLeft();
		}
		waitForElement(creditInfoObj.pay_water);
		creditInfoObj.pay_water.click();
		waitForElement(creditInfoObj.pay_water_confirm_btn);
		creditInfoObj.pay_water_confirm_btn.click();
		return this;
	}

}
