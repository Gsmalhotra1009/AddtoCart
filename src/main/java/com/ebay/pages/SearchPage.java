package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ebay.initdrivers.Driverbase;

public class SearchPage {

	

	//Page factory
		@FindBy(xpath="//a/h3[text()='Apple iPhone 8 Plus 64GB Factory Unlocked AT&T Verizon T-Mobile Unlocked']")
		WebElement itemToBecliked;
	
	public SearchPage() {
		PageFactory.initElements(Driverbase.getDriver(), this);
	}
	
	
	public String validateTheSearchPageTitle() {
		return Driverbase.getDriver().getTitle();
	}

	public Item clickontheItemavailable() {
		itemToBecliked.click();
		return new Item();
	}
}
