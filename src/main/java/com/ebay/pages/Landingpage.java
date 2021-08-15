package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.initdrivers.Driverbase;

public class Landingpage {
	
	//Page factory
	@FindBy(xpath="//input[@class='gh-tb ui-autocomplete-input']")
	WebElement searchbar;
	
	@FindBy(xpath="//input[@class='btn btn-prim gh-spr']")
	WebElement btnsearch;
	
	@FindBy(xpath="//i[@id='gh-cart-n']")
	WebElement addtocartCount;
	
	
	//initializing the page 
	
	public Landingpage() {
		PageFactory.initElements(Driverbase.getDriver(), this);
	}

	public String validateTheLandingPageTitle() {
		return Driverbase.getDriver().getTitle();
	}
	
	public void enterTheValuesinSearchBar(String name) {
		searchbar.sendKeys(name);
			
	}
	
	public SearchPage clickSearchButton() {
		btnsearch.click();
		return new SearchPage();
	}
	
	public int verifyCountintheCart() {
		String countinString = addtocartCount.getText();
		int countIntheList = Integer.parseInt(countinString);
		return countIntheList;
	}
	
}
