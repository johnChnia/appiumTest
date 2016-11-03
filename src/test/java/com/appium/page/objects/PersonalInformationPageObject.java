package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PersonalInformationPageObject {
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_person_name")
	public MobileElement name;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_cnid")
	public MobileElement idCard;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_qq")
	public MobileElement qqNumber;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_marriage")
	public MobileElement marriage;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_degree")
	public MobileElement degree;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_addr")
	public MobileElement addr;
	
	@AndroidFindBy(xpath = ".//*[@text='未婚']")
	public MobileElement select_marriage;
	
	@AndroidFindBy(xpath = ".//*[@text='本科']")
	public MobileElement select_degree;
	
	@AndroidFindBy(xpath = ".//*[@text='河北省']")
	public MobileElement select_province;
	
	@AndroidFindBy(xpath = ".//*[@text='唐山市']")
	public MobileElement select_city;
	
	@AndroidFindBy(xpath = ".//*[@text='路南区']")
	public MobileElement select_area;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/process_next_btn")
	public MobileElement next_btn;
}
