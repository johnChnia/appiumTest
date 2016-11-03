package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PhotoCertificationObject {

	@AndroidFindBy(xpath = ".//*[@text='申请贷款']")
	public MobileElement applyLoan;
}
