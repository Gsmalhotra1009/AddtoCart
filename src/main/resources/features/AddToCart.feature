Feature: To verify Add to cart feature on 



@Sanity  
  Scenario Outline: Verify Add to cart feature is working fine
 	  Given Launch the application
    Then Verify the tite of the landing page
    And Search the "<item>" in searchbar
    When User clicks on search button
    Then Verify the tite of the Search page
    And Select the item from the list 
    Then Verify the tite of the Item page
    And user selects the color of the item from the dropdown
    And User clicks on the button Addtocart
    Then Verify the tite of the landing page
    And AddtoCart icon must be having '<Numberofitems>' item
    
 Examples:
 |item   |Numberofitems|
 |iphone |     1       |
