package com.ebay.Stepdefinition;

import com.ebay.config.Config;
import com.ebay.initdrivers.Driverbase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AddtoCart {
	
	@Given("^Launch the application$")
	public void launch_the_application() throws Throwable {
	    Driverbase.getDriver().get(Config.url);
	}

	@And("^Search the iphone in searchbar$")
	public void search_the_iphone_in_searchbar() throws Throwable {
	   
	}

	@Then("^Verify the tite of the page$")
	public void verify_the_tite_of_the_page() throws Throwable {
	  
	}

	@Then("^Select the item from the list$")
	public void select_the_item_from_the_list() throws Throwable {
	    
	}

	@Then("^Verify the title of the page$")
	public void verify_the_title_of_the_page() throws Throwable {
	    
	}

	@Then("^user selects the color of the item from the dropdown$")
	public void user_selects_the_color_of_the_item_from_the_dropdown() throws Throwable {
	  
	}

	@Then("^User clicks on the button Addtocart$")
	public void user_clicks_on_the_button_Addtocart() throws Throwable {
	   
	}

	@Then("^Verify user is on cart page$")
	public void verify_user_is_on_cart_page() throws Throwable {
	   
	}

	@Then("^AddtoCart icon must be having one item$")
	public void addtocart_icon_must_be_having_one_item() throws Throwable {
	   
	}



}
