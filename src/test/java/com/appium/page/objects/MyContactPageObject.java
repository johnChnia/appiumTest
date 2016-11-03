package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyContactPageObject {

	@AndroidFindBy(id = "co.welab.wolaidai:id/edt_name")
	public MobileElement edit_name;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_add_now")
	public MobileElement add_contact_from_mobile;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_preserve")
	public MobileElement save_btn;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/edt_relation")
	public MobileElement select_relation;
	
	@AndroidFindBy(xpath = ".//*[@text='同事']")
	public MobileElement relation_colleagues;
	
	@AndroidFindBy(xpath = ".//*[@text='父母']")
	public MobileElement relation_friends;
}
