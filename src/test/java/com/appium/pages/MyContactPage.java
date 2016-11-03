package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.MyContactPageObject;

public class MyContactPage extends CommonAppiumTest {

	MyContactPageObject myContactObj = new MyContactPageObject();

	public MyContactPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory
				.initElements(new AppiumFieldDecorator(driver), myContactObj);
	}

	public ContactInfoPage selectContact(String type) throws Exception {
		waitForMyContactPage();
		selectRelation(type);
		clickName();
		addContactFromMobile().selectContact(type); // 临时处理，跳转到了手机通讯录页
		return clickSaveBtn();
	}
	
	public MyContactPage waitForMyContactPage() {
		waitForPageToLoad(myContactObj.edit_name);
		return this;
	}

	public MyContactPage clickName() {
		waitForElement(myContactObj.edit_name);
		myContactObj.edit_name.click();
		return this;
	}

	public SelectContactPage addContactFromMobile() {
		try {
			TimeUnit.SECONDS.sleep(2);
			if (driver.getPageSource().contains("马上添加")) {
				myContactObj.add_contact_from_mobile.click();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SelectContactPage(driver);
	}

	public MyContactPage selectRelation(String type) throws Exception {
		myContactObj.select_relation.click();
		if (type.equalsIgnoreCase("colleagues")) {
			waitForElement(myContactObj.relation_colleagues);
			myContactObj.relation_colleagues.click();
		} else if (type.equalsIgnoreCase("friends")){
			waitForElement(myContactObj.relation_friends);
			myContactObj.relation_friends.click();
		} else {
			throw new Exception("type is colleagues or friends");
		}
		return this;
	}

	public ContactInfoPage clickSaveBtn() {
		waitForElement(myContactObj.save_btn);
		myContactObj.save_btn.click();
		return new ContactInfoPage(driver);
	}
}
