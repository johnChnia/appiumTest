package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RedeemPageObjects {

	@AndroidFindBy(id = "co.welab.wolaidai:id/edit_exchange_code")
	public MobileElement edit_exchange_code;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_exchange")
	public MobileElement exchange_btn;
	
}
