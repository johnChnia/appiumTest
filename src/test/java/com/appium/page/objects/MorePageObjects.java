package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MorePageObjects {

	@AndroidFindBy(xpath = ".//*[@text='安全保障']")
	public MobileElement security_btn;
	
	@AndroidFindBy(xpath = ".//*[@text='新手引导']")
	public MobileElement guide;
	
	@AndroidFindBy(xpath = ".//*[@text='关于我们']")
	public MobileElement about_us;
	
	@AndroidFindBy(xpath = ".//*[@text='检查更新']")
	public MobileElement check_update;
	
	@AndroidFindBy(xpath = ".//*[@text='退出登录']")
	public MobileElement log_out;
	
	@AndroidFindBy(xpath = ".//*[@text='退出']")
	public MobileElement confirm_log_out;
}
