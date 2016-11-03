package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReimbursementPageObject {

	@AndroidFindBy(xpath =  ".//*[@text='还款']")
	public MobileElement repay_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_repay_confirm_submit")
	public MobileElement comfirm_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/pwd_one")
	public MobileElement pwd_0;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/pwd_six")
	public MobileElement pwd_6;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_alert_ok")
	public MobileElement alter_confirm;

	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_repay_confirm_cards")
	public MobileElement use_cards;
	
	@AndroidFindBy(xpath = ".//*[@text='提前还清']")
	public MobileElement pay_in_advance;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_repay_confirm_free_head")
	public MobileElement pay_in_advance_head;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_repay_confirm_free_submit")
	public MobileElement pay_in_advance_confirm_btn;
}
