package com.gaius.console.pages;

import com.microsoft.playwright.Page;


public class HomePage {
	
	private Page page;
	public HomePage(Page page) {
		this.page = page;
	}	
	
	public String getHomePageTitle() {
		String title = page.title();
		return title;
	}
}
