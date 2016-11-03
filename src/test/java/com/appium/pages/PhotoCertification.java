package com.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.appium.config.CommonAppiumTest;
import com.appium.config.NewUserIdentify;
import com.appium.page.objects.PhotoCertificationObject;

public class PhotoCertification  extends CommonAppiumTest{
	public NewUserIdentify n = new NewUserIdentify();
	Properties prop = new Properties();
	public PhotoCertificationObject photoCerObj = new PhotoCertificationObject();
	
	public PhotoCertification(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), photoCerObj);
	}

//	public PhotoCertification waitForPhotoCertificationPage() {
//		waitForElement(photoCerObj.applyLoan);
//		return this;
//	}
	
	public LoanConfirmPage enterLoanConfirmByPhotoCertyPage() {
		new ContactInfoPage(driver).clickNextBtn(); // 把ContactPage的东西放在这里有点不合适，临时这样子处理
		swipeUpUntilTextExists("申请贷款");
		photoCerObj.applyLoan.click();
		return new LoanConfirmPage(driver);
	}
	
	public PhotoCertification fillPhotoCertification(String mobile) {
		try{
		prop.load(new FileInputStream("config.properties"));
		n.identifyPost(mobile, prop.getProperty("docType_face_recognition"));
		n.identifyPost(mobile, prop.getProperty("docType_id_handheld"));
		n.identifyPost(mobile, prop.getProperty("docType_id_front"));
		n.identifyPost(mobile, prop.getProperty("docType_id_back"));
		n.identifyPost(mobile, prop.getProperty("docType_employment"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
}
