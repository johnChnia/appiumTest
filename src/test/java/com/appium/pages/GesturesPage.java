package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.GesturesPageObjects;

@PageName("GesturesPage")
public class GesturesPage extends CommonAppiumTest {

	public GesturesPageObjects gesturesPageObjects = new GesturesPageObjects();

	public GesturesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				gesturesPageObjects);

	}
	
	public GesturesPage waitForGesturesForGesturesPage() {
		waitForPageToLoad(gesturesPageObjects.mLocusPassWordView);
		return this;
	}
	
	/**
	 * 
	 * @return
	 * 专门为需要设置2次手势密码而写的，放在一个里面发现有并发问问题，临时这样子处理
	 */
	public HomePage setGesturesForGesturesPage() {
		waitForGesturesForGesturesPage();
		setGestures();
		setGestures();
		return new HomePage(driver);
	}
	
	/**
	 * 
	 * @param count 设置手势密码
	 * @return
	 */
	public GesturesPage setGestures() {
		try {
			TouchAction ta = new TouchAction(driver);
			int x = gesturesPageObjects.mLocusPassWordView.getLocation().getX();
			int y = gesturesPageObjects.mLocusPassWordView.getLocation().getY();
			int width = gesturesPageObjects.mLocusPassWordView.getSize()
					.getWidth();
			int height = gesturesPageObjects.mLocusPassWordView.getSize()
					.getHeight();
			int num1x = x + width / 6;
			int num1y = y + height / 6;
			// 坐标点的相对位置，按住一个点后，如果向左或向右滑动那么x坐标为元素宽度的1/4，y坐标为0，相对坐标值为正数时向右滑动，为负数时向左滑动
			// 上下滑动时，x相对坐标为0，y的相对坐标为高度的 height/4，相对坐标值为正数时向下滑动，为负数时向上滑动
				ta.press(num1x, num1y).waitAction(500)
						.moveTo((width - x) / 2 * 3 / 4, 0).waitAction(500)
						.moveTo(0, (width - x) / 2 * 3 / 4)
						.moveTo(-(width - x) / 2 * 3 / 4, 0).release()
						.perform();
				TimeUnit.SECONDS.sleep(1);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return this;
	}
}
