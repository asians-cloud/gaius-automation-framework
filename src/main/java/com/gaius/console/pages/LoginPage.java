package com.gaius.console.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	public LoginPage(Page page) {
		this.page = page;
	}
	
	private String forgotPasswordLnk= "a:text('Forgot Password?')";
	private String username = "#username";
	private String password = "#password";
	private String SignInBtn = "#kc-login";	
			
	public String getLoginPageTitle() {
		String title= page.title();
		System.out.println("LoginPage Title: "+ title);
		return title;
	}
	
	public boolean isForgotPasswordLinkExist() {
		return page.isVisible(forgotPasswordLnk);
	}
	public HomePage doLogin(String appUsername,String appPassword) {
		page.fill(username, appUsername);
		page.fill(password, appPassword);
		page.click(SignInBtn);
		return new HomePage(page);
	}

}
