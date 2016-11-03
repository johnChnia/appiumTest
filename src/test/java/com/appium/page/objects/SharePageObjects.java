package com.appium.page.objects;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SharePageObjects {

//	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"share-now\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\").instance(1)")
	public MobileElement share_now;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_share_sina")
	public MobileElement share_sina_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_share_friends")
	public MobileElement share_friends_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_share_circle")
	public MobileElement share_circle_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_share_qq")
	public MobileElement share_qq_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_share_qzone")
	public MobileElement share_zone_btn;
	
	
}
