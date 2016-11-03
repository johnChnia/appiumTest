package com.appium.webtest;

import org.testng.annotations.Test;

import com.annotation.values.Author;
import com.appium.config.User;
import com.appium.config.UserBaseTest;
import com.appium.pages.RedeemPage;
import com.appium.pages.ReimbursementPage;
import com.appium.pages.WelcomePage;

/**
 * 兑换码 → 我的卡卷 → 有奖分享 → 安全设置 → 我的贷款 → 安全保障 → 新手引导 → 关于我们 → 检查更新 → 退出登录
 * 
 * @author john
 * @data 2016年10月9日
 */

public class FlowOtherTest extends UserBaseTest {
	User user;
	WelcomePage welcomePage;

	@Test(groups = "flow")
	@Author(name = "john")
	public void flowOtherTest() throws InterruptedException {
		welcomePage = new WelcomePage(driver);
		user = new User("13310240009", "888888");
		String code = RedeemPage.produceCode();
		
		welcomePage.waitForWelcomePage().swipeLeftToLoginPage(5)
				.setEnvironment().waitForWelcomePage().swipeLeftToLoginPage(7)
				.loginAs(user.getUserName(), user.getPassWord())
				.setGesturesForGesturesPage().waitForHomePage()
				.enterAccountPage().waitForAccountPage().enterRedeemPage()
				.exchange(code).enterMyCardVolume().lookUserRule()
				.enterSharePage().shareByQQ().share().shareByQQZone().share()
				.shareByFriendsCirle().share()
				.shareByWeiXinFriends().share("cheney").shareByWeiBo().share().backToAccountPage()
				.enterSecuritySetPage().enterModifySecurityCodePage()
				.setSecurityCode("111111", "111111")
				.enterModifyGestureCodePage().setGestureForSecurity()
				.backToAccountPage().backToHomePage().enterMorePage()
				.enterGuidePage().flow().checkUpdate().logOut();
	}
}
