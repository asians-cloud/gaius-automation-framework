package com.gaius.console.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.gaius.console.base.BaseTest;
import com.gaius.console.constants.AppConstants;


public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String actTitle= loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOG_IN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void verifyForgotPasswordLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	
}
