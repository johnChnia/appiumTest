package com.appium.pages;

import java.io.FileInputStream;
import java.util.Properties;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.LoginPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

@PageName("LoginPage")
public class LoginPage extends CommonAppiumTest {
	Properties prop = new Properties();
	
    public LoginPageObjects loginPageObjects = new LoginPageObjects();

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
    }

    public GesturesPage loginAs(String username, String password) {
    	typeUsername(username);
    	getVerificationCode();
    	typePassword(password);
    	return signIn();
    }

    public LoginPage typeUsername(String username) {
    	logStepIntoExtentReport(getPageObjectElemetDescription(loginPageObjects,"username"),"SendKeys",username);
        loginPageObjects.username.sendKeys(username);
    	return this;
    }
    
    public LoginPage typePassword(String password) {
    	logStepIntoExtentReport(getPageObjectElemetDescription(loginPageObjects,"password"),"SendKeys",password);
        loginPageObjects.password.sendKeys(password);
    	return this;
    }
    
    public LoginPage getVerificationCode() {
    	logStepIntoExtentReport(getPageObjectElemetDescription(loginPageObjects, "verification_code"), "Click");
    	loginPageObjects.verification_code.click();
    	return this;
    }

    public GesturesPage signIn() {
    	logStepIntoExtentReport(getPageObjectElemetDescription(loginPageObjects, "sign_in"), "Click");
        loginPageObjects.sign_in.click();
        return new GesturesPage(driver);
    }

	public WelcomePage setEnvironment() {
		try {
			prop.load(new FileInputStream("config.properties"));
			waitForPageToLoad(loginPageObjects.set_btn);
			loginPageObjects.set_btn.click();
			loginPageObjects.env_setup.click();
			if (prop.getProperty("ENV").equalsIgnoreCase("i1")) {
				loginPageObjects.integration_btn.click();
			} else if (prop.getProperty("ENV").equalsIgnoreCase("staging")) {
			    loginPageObjects.staging_btn.click();
			} else if (prop.getProperty("ENV").equalsIgnoreCase("i4")) {
				loginPageObjects.integration4_btn.click();
			}
			loginPageObjects.commit_btn.click();
			loginPageObjects.retry_btn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new WelcomePage(driver);
    }
    
    
}
