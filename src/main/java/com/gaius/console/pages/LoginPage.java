package com.gaius.console.pages;

import com.gaius.console.utils.ElementUtils;
import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	private ElementUtils elementUtils;
	
	public LoginPage(Page page) {
		this.page = page;
		elementUtils = new ElementUtils(page);
	}
	
	private String forgotPasswordLnk= "a:text('Forgot Password?')";
	private String username = "#username";
	private String password = "#password";
	private String SignInBtn = "#kc-login";	
			
	public String getLoginPageTitle() {
		String title= page.title();
		return title;
	}
	
	public boolean isForgotPasswordLinkExist() {
		boolean isVisibleFlag = elementUtils.isVisible(forgotPasswordLnk);
		return isVisibleFlag;
	}
	public HomePage doLogin(String appUsername,String appPassword) {
		
		elementUtils.doFill(username, appUsername);
		elementUtils.doFill(password, appPassword);
		elementUtils.doClick(SignInBtn);
		return new HomePage(page);
	}

}
