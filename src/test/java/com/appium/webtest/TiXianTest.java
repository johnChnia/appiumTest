package com.appium.webtest;

import javax.jws.soap.SOAPBinding.Use;

import org.testng.annotations.Test;

import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.TiXianPage;
import com.appium.pages.WelcomePage;

public class TiXianTest extends UserBaseTest{
	User user;
	WelcomePage welcomePage;
	
	@Test
	public void TiXianTest() throws InterruptedException {
		user = new User("18610246662", "888888");
		welcomePage = new WelcomePage(driver);
		
//		TiXianPage.createLimitUsers(user.getUserName());
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().enterTiXianPage().tiXian("3000", user.getUserName());
	}
}
