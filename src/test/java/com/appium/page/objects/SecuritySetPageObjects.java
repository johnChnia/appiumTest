package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SecuritySetPageObjects {

	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_sy_sfae")
	public MobileElement modify_security_code;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/rl_sy_drawges")
	public MobileElement modify_gesture_code;
	
}
