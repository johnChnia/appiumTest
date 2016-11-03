package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WeiBoPageObjects {

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(3)")
	public MobileElement send_btn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
	public MobileElement write_content;
}
