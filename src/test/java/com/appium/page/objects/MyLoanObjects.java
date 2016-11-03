package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyLoanObjects {

	@AndroidFindBy(xpath = ".//android.widget.RelativeLayout[@index=0]/android.widget.RelativeLayout[1]")
	public MobileElement loan_list_1;
	
	@AndroidFindBy(xpath = ".//*[@text='还款中']")
	public MobileElement payment;
	
}
