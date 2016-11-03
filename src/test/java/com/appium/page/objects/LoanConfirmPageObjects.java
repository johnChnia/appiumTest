package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoanConfirmPageObjects {

	@AndroidFindBy(id = "co.welab.wolaidai:id/cb_sbt_check")
	public MobileElement check_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_sbmt_commit")
	public MobileElement commit_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/head_title")
	public MobileElement loanConfirm_text;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(0)")
	public MobileElement confirm_get_code_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/cb_lc_checkbox")
	public MobileElement confirm_checkbox;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_lc_commit")
	public MobileElement confirm_commit_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/head_right_text")
	public MobileElement applyLoan_queding_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_seek_ok")
	public MobileElement loanComfirm_queding_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/confirm_otp_edit_text")
	public MobileElement edt_otp;
	
	@AndroidFindBy(xpath = ".//*[@text='点击绑定您的银行卡']")
	public MobileElement enter_bind_bank;
	
	@AndroidFindBy(xpath = ".//*[@text='下一步']")
	public MobileElement nextStep;
	
	@AndroidFindBy(xpath = ".//*[@text='确认设置']")
	public MobileElement confirm_set_btn;
}
