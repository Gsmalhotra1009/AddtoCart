package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.initdrivers.Driverbase;

public class Landingpage {
	
	//Page facyory
	@FindBy(xpath="//input[@class='gh-tb ui-autocomplete-input']")
	WebElement searchbar;
	
	//initializing the page 
	
	public Landingpage() {
		PageFactory.initElements(Driverbase.getDriver(), this);
	}

}
