package com.ebay.Stepdefinition;


import org.testng.Assert;

import com.ebay.config.Config;
import com.ebay.initdrivers.Driverbase;
import com.ebay.pages.Item;
import com.ebay.pages.Landingpage;
import com.ebay.pages.SearchPage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddtoCart {
	
	Landingpage landingpage = new Landingpage();
	SearchPage searchPage;
	Item item;
	
	@Given("^Launch the application$")
	public void launch_the_application() throws Throwable {
	    Driverbase.getDriver().get(Config.url);
	}
	
	@Then("^Search the \"([^\"]*)\" in searchbar$")
	public void search_the_in_searchbar(String name) throws Throwable {
		landingpage.enterTheValuesinSearchBar(name);
	}
	
	@Then("^Verify the tite of the landing page$")
	public void verify_the_tite_of_the_landing_page() throws Throwable {
		 landingpage.validateTheLandingPageTitle();
	}

	
	@When("^User clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {
	  searchPage = landingpage.clickSearchButton();
	}
	
	@Then("^Verify the tite of the Search page$")
	public void verify_the_tite_of_the_Search_page() throws Throwable {
	   searchPage.validateTheSearchPageTitle();
	}

	@Then("^Select the item from the list$")
	public void select_the_item_from_the_list() throws Throwable {
	    item = searchPage.clickontheItemavailable();
	}

	@Then("^Verify the tite of the Item page$")
	public void verify_the_tite_of_the_Item_page() throws Throwable {
	   item.validateTheItemhPageTitle();
	}

	@Then("^user selects the color of the item from the dropdown$")
	public void user_selects_the_color_of_the_item_from_the_dropdown() throws Throwable {
	  item.selectColorDropDown();
	}

	@Then("^User clicks on the button Addtocart$")
	public void user_clicks_on_the_button_Addtocart() throws Throwable {
	   item.userClicksAddTocart();
	}

	

	@Then("^AddtoCart icon must be having '(\\d+)' item$")
	public void addtocart_icon_must_be_having_item(int count) throws Throwable {
	   landingpage.verifyCountintheCart();
	   Assert.assertEquals(landingpage.verifyCountintheCart(), count);
	}



}
