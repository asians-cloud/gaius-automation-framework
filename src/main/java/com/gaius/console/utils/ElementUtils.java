package com.gaius.console.utils;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
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
	
	public String getLocatorElementText(String locator) {
		String text = page.locator(locator).textContent();
		return text;
	}
	
	public List<String> getLocatorElementsText(String locator) {
		List<String> text = page.locator(locator).allTextContents();
		List<String> elementList = new ArrayList<String>();
		for(String allElementTexts: text) {
			elementList.add(allElementTexts);
			return elementList;
		}
		return null;
	}
	
	public void doClickFirstLocatorElement(String locator) {
		 page.locator(locator).first().click();
	}
	
	public void doClickLastLocatorElement(String locator) {
		 page.locator(locator).last().click();
	}
	
	public void doClickLocatorElementsText(String locator, String elementValue) {
		
		Locator text = page.locator(locator);
		for(int i=0;i<text.count();i++) {
			
		String element= text.nth(i).textContent();
			if(element.equals(elementValue)) {
				text.nth(i).click();
				break;
			}
		}
		return;
	}
	
	public String getLocatorElementTextInFrame(String frameLocator, String elementLocator){
	
			String elementValue= page.frame(frameLocator).locator(elementLocator).textContent();
			return elementValue;
	}
	
	public void doClickLocatorElementTextInFrame(String frameLocator, String elementLocator){
		
		page.frame(frameLocator).locator(elementLocator).click();
	}
	
	public void doFillLocatorElementTextInFrame(String frameLocator, String elementLocator,String text){
		
		page.frame(frameLocator).locator(elementLocator).fill(text);
	}
	public List<String> getTableData(String scopeLocator) 
	{
		List<String> row = page.locator(scopeLocator).allInnerTexts();
		List<String> dataList = new ArrayList<>();
		for(String element:row) {
			 dataList.add(element);
			 return dataList;
		}
		return null;
	}
	
	public void getElementFromTable(String tableLocator,String scopeLocator, String elementToBeSearch, String locator) {
		Locator row = page.locator(tableLocator);
		row.locator(scopeLocator, new Locator.LocatorOptions().setHasText(elementToBeSearch)).locator(locator).click();
	}
	
	public void scrollDown(String locator) {
		page.keyboard().press("PageDown");
	}
}
