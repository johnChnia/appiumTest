package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.CardAuthPageObject;

public class CardAuthPage extends CommonAppiumTest {

	CardAuthPageObject cardAuthObj = new CardAuthPageObject();

	public CardAuthPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), cardAuthObj);
	}

	public CardAuthPage waitForCardAuthPage() {
		waitForPageToLoad(cardAuthObj.edit_credit_card_num);
		return this;
	}

	/**
	 * 银行卡授权
	 * @param cardNum
	 * @return
	 */
	public CreditInfoPage fillCardAuthorization(String cardNum) {
		waitForCardAuthPage();
		cardAuthObj.edit_credit_card_num.click();
		inputBankCardNum(cardNum);
		return clickConfirmBtn();
	}

	public CreditInfoPage clickConfirmBtn() {
		cardAuthObj.credit_card_confirm_btn.click();
		return new CreditInfoPage(driver);
	}
	
	public CardAuthPage inputBankCardNum(String cardNum) {
		String actualCardNum = null;
		int doCount = 0;
		MobileElement bankCard = cardAuthObj.edit_credit_card_num;
		String[] cardNumList = cardNum.split("");
		do {
			for (int j = 0; j < cardNumList.length; j++) {
				pressKeyCode(Integer.parseInt(cardNumList[j]) + 7);
				// 如果当前长度超过预期的值说明多输入了一个数字，需要回删一个字符 6217002950000161321 13 9 8 14
				if (bankCard.getText().replace(" ", "").length() > (j + 1)) {
					System.out.println("长度输入超过预期，需要回删一个字符");
					pressKeyCode(67);
				}

				if (j == cardNumList.length / 2) {
					bankCard.click(); // 点击元素，确保与Appium有交互，否则会超时自动关闭session
					pressKeyCode(123); // 将光标移动到末尾
				}
			}
			actualCardNum = bankCard.getText().replace(" ", "");
			System.out.println("第 " + (doCount + 1) + " 次输入,期望值为: " + cardNum
					+ " 实际值为：" + actualCardNum + " "
					+ cardNum.equals(actualCardNum));
			doCount++;
			if (!actualCardNum.equals(cardNum)) {
				bankCard.clear();
			}
		} while (!actualCardNum.equals(cardNum));
		return this;
	}
}
