package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectContactPageObject {

	@AndroidFindBy(xpath = ".//*[@text='张三']")
	public MobileElement select_colleagues;
	
	@AndroidFindBy(xpath = ".//*[@text='李四']")
	public MobileElement select_friends;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/head_title")
	public MobileElement waitSelectContactPage;
}
