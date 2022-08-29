package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ebay.initdrivers.Driverbase;

public class SearchPage {

	

	//Page factory
		@FindBy(xpath="//img[@class='s-item__image-img' and @src='https://i.ebayimg.com/thumbs/images/g/IYAAAOSwXtFiOInB/s-l225.webp']")
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
