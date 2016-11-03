package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.PersonalInformationPageObject;
import com.appium.utils.IdCardGenerator;

public class PersonalInformationPage extends CommonAppiumTest{

	IdCardGenerator g = new IdCardGenerator();  
	PersonalInformationPageObject personallyInforObj = new PersonalInformationPageObject();
	public PersonalInformationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), personallyInforObj);
	}

	public PersonalInformationPage waitforPersonalInforPage() {
		waitForPageToLoad(personallyInforObj.name);
		return this;
	}
	
	public WorkUnitPage fillPersonalInfor(String name) {
		waitforPersonalInforPage();
		typeName(name);
		typeIdCard();
		selectMarriage();
		selectDegree();
		typeQQ();
		selectLivingArea();
		clickNextButton();
		return clickNextButton();
	}
	
	public PersonalInformationPage typeName(String name) {
		personallyInforObj.name.sendKeys(name);
		return this;
	}
	
	public PersonalInformationPage typeIdCard() {
		String idCard = g.generate();
		personallyInforObj.idCard.sendKeys(idCard);
		return this;
	}
	
	public PersonalInformationPage selectMarriage() {
		personallyInforObj.marriage.click();
		waitForElement(personallyInforObj.select_marriage);
		personallyInforObj.select_marriage.click();
		return this;
	}
	
	public PersonalInformationPage typeQQ() {
		personallyInforObj.qqNumber.sendKeys("314863321");
		return this;
	}
	
	public PersonalInformationPage selectDegree() {
		personallyInforObj.degree.click();
		waitForElement(personallyInforObj.select_degree);
		personallyInforObj.select_degree.click();
		return this;
	}
	
	public PersonalInformationPage selectLivingArea() {
		personallyInforObj.addr.click();
		waitForElement(personallyInforObj.select_province);
		personallyInforObj.select_province.click();
		waitForElement(personallyInforObj.select_city);
		personallyInforObj.select_city.click();
		waitForElement(personallyInforObj.select_area);
		personallyInforObj.select_area.click();
		return this;
	}
	
	public WorkUnitPage clickNextButton() {
		waitForElement(personallyInforObj.next_btn);
		personallyInforObj.next_btn.click();
		return new WorkUnitPage(driver);
	}
}
