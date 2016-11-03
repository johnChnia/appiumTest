package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreditInfoPageObject {

	@AndroidFindBy(xpath = ".//*[@text='银行卡']")
	public MobileElement card_auth;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/process_next_btn")
	public MobileElement next_btn;
	
	@AndroidFindBy(xpath = ".//*[@text='工资卡流水']")
	public MobileElement pay_water;
	
	@AndroidFindBy(xpath = ".//*[@text='确定']")
	public MobileElement pay_water_confirm_btn;
}
