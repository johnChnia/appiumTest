package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CardAuthPageObject {

	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_credit_card_number")
	public MobileElement edit_credit_card_num;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_credit_card_collect_confirm")
	public MobileElement credit_card_confirm_btn;
}
