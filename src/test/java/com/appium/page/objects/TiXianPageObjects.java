package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TiXianPageObjects {

	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_my_cash_submit")
	public MobileElement liJiTiXianBtn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_withdrawals_amount")
	public MobileElement edit_amount;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rb_withdrawals0")
	public MobileElement select_date;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_withdrawals_submit")
	public MobileElement tixian_confirm_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_withdrawals_otp")
	public MobileElement getAuthCode;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_withdrawals_otp")
	public MobileElement edit_otp;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/cb_withdrawals")
	public MobileElement agree_agreement;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_withdrawals_commit")
	public MobileElement confirm_tixian_confirm_btn;
}
