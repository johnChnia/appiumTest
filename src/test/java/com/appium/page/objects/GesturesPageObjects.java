package com.appium.page.objects;

import com.annotation.values.ElementDescription;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GesturesPageObjects {
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@resource-id, 'co.welab.wolaidai:id/mLocusPassWordView')]")
	@ElementDescription("手势密码")
	public MobileElement mLocusPassWordView;
}
