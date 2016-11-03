package com.appium.page.objects;


import org.openqa.selenium.support.CacheLookup;

import com.annotation.values.ElementDescription;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageObjects {
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/ed_reg_tel")
	@ElementDescription("UserName Field")
	@CacheLookup
	public MobileElement username;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/ed_reg_yancode")
	@ElementDescription("Password Field")
	@CacheLookup
	public MobileElement password;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_reg_ok")
	@ElementDescription("登录")
	@CacheLookup
	public MobileElement sign_in;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_reg_yancode")
	@ElementDescription("获取验证码")
	@CacheLookup
	public MobileElement verification_code;

	@AndroidFindBy(id = "co.welab.wolaidai:id/login_setting_btn")
	@ElementDescription("设置")
	@CacheLookup
	public MobileElement set_btn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@index,3)]")
	@ElementDescription("环境设置")
	@CacheLookup
	public MobileElement env_setup;
	

	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_staging")
	@ElementDescription("staging")
	@CacheLookup
	public MobileElement staging_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_integration")
	public MobileElement integration_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_integration4")
	public MobileElement integration4_btn;
	
	@AndroidFindBy(id = "android:id/button2")
	@ElementDescription("提交")
	@CacheLookup
	public MobileElement commit_btn;
	
	//android.widget.TextView[contains(@index,1)]
	@AndroidFindBy(xpath = ".//*[@text='重试']")
	@ElementDescription("重试")
	@CacheLookup
	public MobileElement retry_btn;

}
