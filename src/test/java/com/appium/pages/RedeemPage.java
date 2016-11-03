package com.appium.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.RedeemPageObjects;
import com.appium.utils.DBUtil;


public class RedeemPage extends CommonAppiumTest{

	RedeemPageObjects redeemPageObjects = new RedeemPageObjects();
	static Properties properties = new Properties();

	
	public RedeemPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				redeemPageObjects);
	}

	public AccountPage exchange(String code) {
		waitForRedeemPage();
		enterRedeemCode(code);
		clickExchangeBtn();
		return backToAccountPage();
	}
	
	public RedeemPage waitForRedeemPage() {
		waitForPageToLoad(redeemPageObjects.edit_exchange_code);
		return this;
	}
	
	public RedeemPage enterRedeemCode(String code) {
		redeemPageObjects.edit_exchange_code.sendKeys(code);
		return this;
	}

	public RedeemPage clickExchangeBtn() {
		redeemPageObjects.exchange_btn.click();
		return this;
	}
	
	public AccountPage backToAccountPage() {
		clickBackButton();
		return new AccountPage(driver);
	}
	
	public static String createCode() {
		 String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        char[] rands = new char[6]; 
	        for (int i = 0; i < rands.length; i++) 
	        { 
	            int rand = (int) (Math.random() * a.length()); 
	            rands[i] = a.charAt(rand); 
	        } 
		return String.valueOf(rands);
	}
	
	public static String produceCode() {
		String code = null;
		try {
			code = createCode();
			
			properties.load(new FileInputStream("config.properties"));
			String sqlForRedeem = properties.getProperty("sqlForRedeem");
			String sqlForCoupons = properties.getProperty("sqlForCoupons");
			DBUtil.getConnection("mysql");
			DBUtil.execute(sqlForRedeem,code);
			DBUtil.execute(sqlForCoupons, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return code;
		
	}
}
