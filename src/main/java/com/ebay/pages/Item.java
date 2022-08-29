package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.initdrivers.Driverbase;

public class Item {

	
	@FindBy(xpath="//select[@id='msku-sel-1']/option[@id='msku-opt-2']")
	WebElement colorNameDropdown;
	
	@FindBy(xpath="//span[@class='ux-call-to-action__text' and text()='Add to cart']")
	WebElement btnAddToCart;
	
	public Item() {
		PageFactory.initElements(Driverbase.getDriver(), this);
	}
	
	
	public String validateTheItemhPageTitle() {
		System.out.println(Driverbase.getDriver().getTitle());
		return Driverbase.getDriver().getTitle();
	}

	public void selectColorDropDown() {
		colorNameDropdown.click();
	}
	
	public void userClicksAddTocart() {
		btnAddToCart.click();
	}
}
