package com.appium.page.objects;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

public class SecurityPageObjects {

	@FindBy(css = "body > div > div.faq-box > div > div.fqa-section-ct > dl:nth-child(1) > dt")
	public MobileElement professional;

}
