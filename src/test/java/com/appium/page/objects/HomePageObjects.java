package com.appium.page.objects;

import com.annotation.values.ElementDescription;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageObjects {

	
	@AndroidFindBy(xpath = ".//*[@text='6月']")
	@ElementDescription("贷款期限6月")
	public MobileElement loan_time;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_home_list_view_top_apply")
	@ElementDescription("立即申请")
	public MobileElement apply_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tsb_home_list_top_amounts")
	@ElementDescription("申请金额3000")
	public MobileElement apply_amount;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_usercenter")
	public MobileElement account;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_more")
	public MobileElement more;
	
	@AndroidFindBy(xpath = ".//*[@text='审批通过,请确认']")
	public MobileElement approve_confirm;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/worker_image")
	public MobileElement identity_gx;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/identity_confirm_btn")
	public MobileElement identity_confirm_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_home_list_view_top_withdraw_cash")
	public MobileElement tiXian;
}
