package com.gaius.console.base;

import java.util.Properties;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.gaius.console.factory.PlaywrightFactory;
import com.gaius.console.pages.HomePage;
import com.gaius.console.pages.LoginPage;
import com.microsoft.playwright.Page;

public class BaseTest {

	PlaywrightFactory playwrightFactory;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;


	@BeforeTest
	public void setup() {
		playwrightFactory = new PlaywrightFactory();

		prop = playwrightFactory.init_prop();

		/*
		 * if (browserName != null) { prop.setProperty("browser", browserName); }
		 */
		page = playwrightFactory.initBrowser(prop);
		loginPage = new LoginPage(page);
		//homePage =  new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
