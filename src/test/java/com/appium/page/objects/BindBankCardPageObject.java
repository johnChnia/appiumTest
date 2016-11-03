package com.appium.page.objects;


import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BindBankCardPageObject {

	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"银行卡号\")")
	public MobileElement input_bankCard;

	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"绑定银行卡\")")
	public MobileElement bind_bankCard_btn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"下一步\")")
	public MobileElement next_step_btn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
//	@AndroidFindBy(xpath = "//android.widget.ListView[contains(@index, 1)]/android.view.View[1]")
	public MobileElement edit_pay_passwd;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"获取验证码\")")
	public MobileElement get_verification_code;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
	public MobileElement edit_verification_code;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"确定\")")
	public MobileElement confirm_btn;
}

