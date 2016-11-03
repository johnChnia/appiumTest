package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ContactInfoPageObject {

	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_listcontact_name")
	public MobileElement colleagues;
	
	@AndroidFindBy(xpath = ".//*[@text='姓名']")
	public MobileElement friends;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/process_next_btn")
	public MobileElement next_btn;
	
}
