package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyCardVolumeObjects {

	@AndroidFindBy(id = "co.welab.wolaidai:id/head_right_text")
	public MobileElement use_rule;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_grid_bonus_item_root")
	public MobileElement bonus_item_root;
	
	@AndroidFindBy(xpath = ".//*[@text='使用']")
	public MobileElement use_btn;
	
	@AndroidFindBy(xpath = ".//*[@text='使用规则']")
	public MobileElement wait_look_rule;
}
