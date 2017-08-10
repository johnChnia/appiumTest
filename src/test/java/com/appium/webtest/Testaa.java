package com.appium.webtest;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.pages.LoanConfirmPage;
import com.appium.pages.ReimbursementPage;
import com.appium.pages.TiXianPage;
import com.appium.utils.IdCardGenerator;

public class Testaa {
	@Test
	public void testa() throws MalformedURLException {
//		LoanConfirmPage.approval("18612343344");
		ReimbursementPage.prepareForPayInAdvance("18610241122");
//		System.out.println(new IdCardGenerator().generate());
//		TiXianPage.createLimitUsers("18610246663");

}
}