package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.MyLoanObjects;

public class MyLoan extends CommonAppiumTest{

	MyLoanObjects myLoanObjects = new MyLoanObjects();
	public MyLoan(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myLoanObjects);
	}
	
	
	public void enterLoanDetailPage() {
		myLoanObjects.loan_list_1.click();
	}
	
	public MyLoan waitForReimbursementPage() {
		waitForPageToLoad(myLoanObjects.payment);
		return this;
	}
	
	public ReimbursementPage enterReimbursementPage() {
		waitForElement(myLoanObjects.payment);
		myLoanObjects.payment.click();
		return new ReimbursementPage(driver);
	}
}
