package com.gaius.console.pages;

import com.gaius.console.utils.ElementUtils;
import com.microsoft.playwright.Page;

public class AddDomainPage {
	
	private Page page;
	private ElementUtils elementUtils;
	
	public AddDomainPage(Page page) {
		this.page = page;
		elementUtils = new ElementUtils(page);
	}	
	
	private String domainNameTxtBox="#domain_name";
	private String addNewTargetTxtBox="#add_new_target";
	private String addNewTargetAddBtn= "div[class='d-flex justify-content-end mt-n4'] button[type='button']";
	private String upStreamProtocol ="div[class='ant-btn-group'] button:nth-child(1)";
	private String shadowDomainTab = "text=Shadow Domain";
	private String shadowDomainTxtBox = "#uid-n03l1pmaevg";
	private String addPlusIcon ="button[class='btn close btn-black btn-sm']";
	private String saveBtn = "div[class='d-flex justify-content-end mt-n4'] button[type='button']";
	
	public void doFillBasicConfiguration(String domainNameVal, String addNewTargetVal,String shadowDomainVal) {
		elementUtils.doFill(domainNameTxtBox, domainNameVal);
		elementUtils.scrollDown(shadowDomainVal);
		elementUtils.doFill(addNewTargetTxtBox, addNewTargetVal);
		elementUtils.doClick(addNewTargetAddBtn);
		elementUtils.doClick(upStreamProtocol);
		elementUtils.doClickLastLocatorElement(shadowDomainTab);
		elementUtils.doFill(shadowDomainTxtBox, shadowDomainVal);
		elementUtils.doClick(addPlusIcon);
		elementUtils.doClick(saveBtn);
	}
	
	
	
	
	
}
