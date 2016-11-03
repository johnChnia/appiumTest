package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class QQZoneObjects {

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(1)")
	public MobileElement send_btn;
	
}
