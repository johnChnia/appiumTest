package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class QQPageObjects {
	
	@AndroidFindBy(xpath = ".//*[@text='我的电脑']")
//	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
	public MobileElement sendTo;

	@AndroidFindBy(id = "com.tencent.mobileqq:id/dialogRightBtn")
	public MobileElement send_btn;
	
	@AndroidFindBy(id = "com.tencent.mobileqq:id/dialogLeftBtn")
	public MobileElement back_to_sharePage;
}
