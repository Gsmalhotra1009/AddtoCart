Feature: To verify Add to cart feature on 



@Sanity  
  Scenario: Verify Add to cart feature is working fine
 	  Given Launch the application
    Then Verify the tite of the page
    And Select the item from the list 
    Then Verify the title of the page
    And user selects the color of the item from the dropdown
    And User clicks on the button Addtocart
    Then Verify user is on cart page
    And AddtoCart icon must be having one item
    
 
