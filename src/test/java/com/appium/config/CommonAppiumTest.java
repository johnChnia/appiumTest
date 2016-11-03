package com.appium.config;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.appium.manager.AppiumParallelTest;
import com.relevantcodes.extentreports.LogStatus;
import com.report.factory.ExtentTestManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonAppiumTest {
	public AppiumDriver driver;
	public AppiumParallelTest appiumParallelTest = new AppiumParallelTest();
	Logger logger = Logger.getLogger(CommonAppiumTest.class);

	public CommonAppiumTest(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	/***
	 * 
	 * @param id
	 *            等待页面加载，默认15秒
	 */
	public void waitForPageToLoad(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	/**
	 * 
	 * @param id
	 *            等待元素变成可见的，默认等待15S
	 */
	public void waitForElementToDisAppear(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
	}

	public WebElement waitForElement(WebElement arg) {
		waitForPageToLoad(arg);
		WebElement el = arg;
		return el;
	}

	/***
	 * 
	 * @param expected
	 *            向右滑动，直到期待的字符出现
	 */
	public void swipeRightUntilTextExists(String expected) {
		do {
			swipeRight();
		} while (!driver.getPageSource().contains(expected));
	}

	/***
	 * 
	 * @param expected
	 *            向左滑动，直到等待的字符出现
	 */
	public void swipeLeftUntilTextExists(String expected) {
		do {
			swipeLeft();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!driver.getPageSource().contains(expected));
	}

	/**
	 * 
	 * @param expected
	 *            向上滑动，直到等到的字符出现
	 */
	public void swipeUpUntilTextExists(String expected) {
		do {
			swipeUp();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!driver.getPageSource().contains(expected));
	}

	/***
	 * 向右滑动
	 */
	public void swipeRight() {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.9);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		driver.swipe(startx, starty, endx, starty, 1000);
	}

	/***
	 * 向左滑动
	 */
	public void swipeLeft() {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.8);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		driver.swipe(startx, starty, endx, starty, 500);
	}

	/**
	 * 向上滑动
	 */
	public void swipeUp() {
		Dimension size = driver.manage().window().getSize();
		int startx = size.width / 2;
		int starty = (int) (size.height * 3 / 4);
		int endy = (int) (size.height / 4);
		driver.swipe(startx, starty, startx, endy, 1000);
	}

	/***
	 * 
	 * @param Id
	 * @param arg
	 *            在给定的元素上滑动屏幕，默认持续时间为1S
	 */
	public void scrollDirection(MobileElement Id, SwipeElementDirection arg) {
		MobileElement e = Id;
		e.swipe(arg, 1000);
	}

	/***
	 * 
	 * @param context
	 *            设置Context上下文
	 */
	public void setContext() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println("##############");
			System.out.println(contextName); // prints out something like
												// NATIVE_APP \n WEBVIEW_1
		}
		driver.context((String) contextNames.toArray()[1]); // set context to
															// WEBVIEW_1

		System.out.println("Current context" + driver.getContext());
	}

	/***
	 * 返回键，返回上一个Activity
	 */
	public void clickBackButton() {
		driver.navigate().back(); // Closes keyboard
		// driver.navigate().back(); //Comes out of edit mode
	}

	public String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	/***
	 * 
	 * @param elementDescription
	 * @param action
	 * @param typeString
	 *            输出 Input操作日志
	 */
	public void logStepIntoExtentReport(String elementDescription,
			String action, String typeString) {
		ExtentTestManager.getTest().log(
				LogStatus.INFO,
				withBoldHTML(action),
				elementDescription + "; " + withBoldHTML("Text") + ": "
						+ typeString);
	}

	/**
	 * 
	 * @param elementDescription
	 * @param action
	 *            输出点击操作日志
	 */
	public void logStepIntoExtentReport(String elementDescription, String action) {
		ExtentTestManager.getTest().log(LogStatus.INFO, withBoldHTML(action),
				elementDescription + "按钮");
	}

	public String withBoldHTML(String string) {
		if (!string.trim().isEmpty()) {
			return "<b>" + string + "</b>";
		} else {
			return "";
		}
	}

	/***
	 * 
	 * @param pageObject
	 * @param fieldName
	 * @return 获取 pageObject描述
	 */
	public String getPageObjectElemetDescription(Object pageObject,
			String fieldName) {
		try {
			return this.getClass().getAnnotation(PageName.class).value()
					+ "::"
					+ pageObject.getClass().getField(fieldName)
							.getAnnotation(ElementDescription.class).value();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 模拟键盘输入
	 * 
	 * @param keyCode
	 */
	public void pressKeyCode(int keyCode) {
		String device = Thread.currentThread().getName().split("_")[1];
		String cmdStr = "adb -s " + device + " shell input keyevent " + keyCode
				+ "";
		try {
			Runtime.getRuntime().exec(cmdStr);
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
