package com.gaius.console.utils;

import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Page;

public class ElementUtils {
	
	private Page page;
	public ElementUtils(Page page) {
		this.page = page;
	}
	
	public void doFill(String locator,String value) {
		page.fill(locator, value);
	}
	
	public void doClick(String locator) {
		page.click(locator);
	}
	public boolean isVisible(String locator) {
		return page.isVisible(locator);
	}

}
