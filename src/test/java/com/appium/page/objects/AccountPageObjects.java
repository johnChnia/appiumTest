package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountPageObjects {

	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_coupon")
	public MobileElement my_cardVolume;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_redeem_code")
	public MobileElement redeem_code;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_pi_safe")
	public MobileElement security_set;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_bonus_share")
	public MobileElement bonus_share;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/text_shenqingNum")
	public MobileElement my_loan;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_coupon")
	public MobileElement my_card_valume;
	
}

