package com.appium.config;

import com.appium.manager.AppiumParallelTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class UserBaseTest extends AppiumParallelTest {

    JSonParser jSonParser = new JSonParser();

    /**
     * 
     * @param name
     * @throws Exception
     * 启动 Appium client
     */
    @BeforeMethod(alwaysRun = true) public void startApp(Method name) throws Exception {
        driver = startAppiumServerInParallel(name.getName(), androidNative());
        startLogResults(name.getName());
    }

    /**
     * 
     * @param result
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     * 关闭 Appium client
     */
    @AfterMethod(alwaysRun = true) public void killServer(ITestResult result)
        throws InterruptedException, IOException, URISyntaxException {
        endLogTestResults(result);
        getDriver().quit();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    /**
     * 
     * @throws Exception
     * 启动 Appium Server
     */
    @BeforeClass() public void beforeClass() throws Exception {
    	 System.out.println("Before Class called" + Thread.currentThread().getId());
         System.out.println(getClass().getName());
         startAppiumServer(getClass().getSimpleName());
    }

    /**
     * 
     * @throws InterruptedException
     * @throws IOException
     * 关闭 Appium Server
     */
    @AfterClass() public void afterClass() throws InterruptedException, IOException {
    	System.out.println("After Class" + Thread.currentThread().getId());
        killAppiumServer();
    }

    public String getUserName() {
        String[] crds = Thread.currentThread().getName().toString().split("_");
        System.out.println(crds[1]);
        JSONObject user = jSonParser.getUserData(Integer.parseInt(crds[1]));
        return user.get("userName").toString();
    }

    public String getPassword() {
        String[] crds = Thread.currentThread().getName().toString().split("_");
        JSONObject user = jSonParser.getUserData(Integer.parseInt(crds[1]));
        return user.get("password").toString();
    }

    /***
     * IOS DesiredCapabilities
     */
    public DesiredCapabilities iosNative() {
        DesiredCapabilities iOSCapabilities = new DesiredCapabilities();
        System.out.println("Setting iOS Desired Capabilities:");
        iOSCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        iOSCapabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("IOS_APP_PATH"));
        iOSCapabilities
            .setCapability(IOSMobileCapabilityType.BUNDLE_ID, prop.getProperty("BUNDLE_ID"));
        iOSCapabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
        iOSCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        iOSCapabilities.setCapability(MobileCapabilityType.UDID, device_udid);
        return iOSCapabilities;
    }

    /**
     * Android DesiredCapabilities
     */
    public synchronized DesiredCapabilities androidNative() {
        System.out.println("Setting Android Desired Capabilities:");
        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        androidCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.X");
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
            prop.getProperty("APP_ACTIVITY"));
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
            prop.getProperty("APP_PACKAGE"));
        androidCapabilities.setCapability("browserName", "");
        androidCapabilities
            .setCapability(MobileCapabilityType.APP, prop.getProperty("ANDROID_APP_PATH"));
        androidCapabilities.setCapability(MobileCapabilityType.UDID, device_udid);
        
        androidCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);  // todo
        androidCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);  // todo
        androidCapabilities.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
        androidCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "/Users/john/Documents/workspace/chromedriver");
        return androidCapabilities;
    }
}
