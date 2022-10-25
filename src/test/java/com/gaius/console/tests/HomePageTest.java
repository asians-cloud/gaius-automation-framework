package com.gaius.console.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.gaius.console.base.BaseTest;
import com.gaius.console.constants.AppConstants;


public class HomePageTest extends BaseTest{
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		homePage= loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String actHomePageTitle= homePage.getHomePageTitle();
		Assert.assertEquals(actHomePageTitle, AppConstants.HOME_PAGE_TITLE);
		
	}

}
