package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WorkUnitPageObject {

	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_com_type")
	public MobileElement industry_btn;
	
	@AndroidFindBy(xpath = ".//*[@text='制造、工厂、加工']")
	public MobileElement industryCategories;
	
	@AndroidFindBy(xpath = ".//*[@text='食品、饮料加工及制造']")
	public MobileElement specificIndustry;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_unit_name")
	public MobileElement unit_name;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_unit_tel")
	public MobileElement unit_tel;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_unit_department")
	public MobileElement unit_department;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_position")
	public MobileElement unit_position;
	
	@AndroidFindBy(xpath = ".//*[@text='企业负责人']")
	public MobileElement select_position;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_time")
	public MobileElement ruzhiTime;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_money_in")
	public MobileElement income;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/et_addr_detail")
	public MobileElement detailAddr;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/tv_addr")
	public MobileElement unitAddr;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/btn_ok")
	public MobileElement ruzhiTime_btn;
	
	@AndroidFindBy(xpath = ".//*[@text='河北省']")
	public MobileElement select_province;
	
	@AndroidFindBy(xpath = ".//*[@text='唐山市']")
	public MobileElement select_city;
	
	@AndroidFindBy(xpath = ".//*[@text='路南区']")
	public MobileElement select_area;
	
	@AndroidFindBy(id = "co.welab.wolaidai:id/process_next_btn")
	public MobileElement next_btn;
}
