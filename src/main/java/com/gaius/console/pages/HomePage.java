package com.gaius.console.pages;

import com.gaius.console.utils.ElementUtils;
import com.microsoft.playwright.Page;


public class HomePage {
	
	private Page page;
	private ElementUtils elementUtils;
	
	public HomePage(Page page) {
		this.page = page;
		elementUtils = new ElementUtils(page);
	}	
	
	public String getHomePageTitle() {
		String title = page.title();
		return title;
	}
	private String addDomainBtn="#add-domain";
	
	public AddDomainPage createDomain() {
		
		elementUtils.doClick(addDomainBtn);
		return new AddDomainPage(page);
	}
}
