package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WeixinFriendsPageObjects {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
	public MobileElement search_editText;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(2)")
	public MobileElement send_to;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(1)")
	public MobileElement send_btn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(0)")
	public MobileElement back_to_sharePage;
}
