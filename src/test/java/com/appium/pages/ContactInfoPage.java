package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.ContactInfoPageObject;

public class ContactInfoPage extends CommonAppiumTest {

	ContactInfoPageObject contactInfoObj = new ContactInfoPageObject();

	public ContactInfoPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				contactInfoObj);
	}

	public ContactInfoPage waitForContactInfoPage() {
		waitForPageToLoad(contactInfoObj.colleagues);
		return this;
	}

	public PhotoCertification fillContactInfo() throws Exception {
		enterMyContactPageForColleagues().selectContact("colleagues")
				.enterMyContactPageForFriends().selectContact("friends");
		return new PhotoCertification(driver);
	}

	public MyContactPage enterMyContactPageForColleagues() {
		waitForContactInfoPage();
		return clickColleagues();
	}

	public MyContactPage enterMyContactPageForFriends() {
		waitForContactInfoPage();
		return clickFriends();
	}

	public MyContactPage clickColleagues() {
		contactInfoObj.colleagues.click();
		return new MyContactPage(driver);
	}

	public MyContactPage clickFriends() {
		contactInfoObj.friends.click();
		return new MyContactPage(driver);
	}
	
	public PhotoCertification clickNextBtn() {
		waitForElement(contactInfoObj.next_btn);
		contactInfoObj.next_btn.click();
		return new PhotoCertification(driver);
	}
}
