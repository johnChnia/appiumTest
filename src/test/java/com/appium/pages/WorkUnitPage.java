package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.WorkUnitPageObject;

public class WorkUnitPage extends CommonAppiumTest{

	WorkUnitPageObject workUnitPageObj = new WorkUnitPageObject();
	public WorkUnitPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), workUnitPageObj);
	}

	public WorkUnitPage waitForWorkUnitPage() {
		waitForPageToLoad(workUnitPageObj.industry_btn);
		return this;
	}
	
	public CreditInfoPage fillWorkUnit() {
		waitForWorkUnitPage();
		selectIndustry();
		typeUnitName();
		typeUnitTel();
		swipeUp(); // 不滑动看到下面的输入框
		typeUnitDepart();
		selectPosition();
		selectRuZhiTime();
		typeIncome();
		selectUnitAddr();
		typeDetailAddr();
		return clickNextButton();
	}
	
	public WorkUnitPage selectIndustry() {
		workUnitPageObj.industry_btn.click();
		waitForElement(workUnitPageObj.industryCategories);
		workUnitPageObj.industryCategories.click();
		waitForElement(workUnitPageObj.specificIndustry);
		workUnitPageObj.specificIndustry.click();
		return this;
	}
	
	public WorkUnitPage typeUnitName() {
		workUnitPageObj.unit_name.sendKeys("自动化测试集团");
		return this;
	}
	
	public WorkUnitPage typeUnitTel() {
		workUnitPageObj.unit_tel.sendKeys("01088888888");
		return this;
	}
	
	public WorkUnitPage typeUnitDepart() {
		workUnitPageObj.unit_department.sendKeys("自动化测试部门");
		return this;
	}
	
	public WorkUnitPage selectPosition() {
		workUnitPageObj.unit_position.click();
		waitForElement(workUnitPageObj.select_position);
		workUnitPageObj.select_position.click();
		return this;
	}
	
	public WorkUnitPage selectRuZhiTime() {
		workUnitPageObj.ruzhiTime.click();
		waitForElement(workUnitPageObj.ruzhiTime_btn);
		workUnitPageObj.ruzhiTime_btn.click();
		return this;
	}
	
	public WorkUnitPage typeIncome() {
		workUnitPageObj.income.sendKeys("10000");
		return this;
	}
	
	public WorkUnitPage selectUnitAddr() {
		workUnitPageObj.unitAddr.click();
		waitForElement(workUnitPageObj.select_province);
		workUnitPageObj.select_province.click();
		waitForElement(workUnitPageObj.select_city);
		workUnitPageObj.select_city.click();
		waitForElement(workUnitPageObj.select_area);
		workUnitPageObj.select_area.click();
		return this;
	}
	
	public WorkUnitPage typeDetailAddr() {
		waitForElement(workUnitPageObj.detailAddr);
		workUnitPageObj.detailAddr.sendKeys("我是穆里尼奥粉");
		return this;
	}
	
	public CreditInfoPage clickNextButton() {
		workUnitPageObj.next_btn.click();
		return new CreditInfoPage(driver);
	}
	
}
