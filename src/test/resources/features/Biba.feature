Feature: Biba Brand Functionality
  As a user
  I want to view Biba products
  So that I can purchase them

  Background:
    Given I am on the home page
    And I select the "Biba" brand

  Scenario: Verify Biba Page Title
    Then I should see the Biba brand products page
    And I should see "Biba" brand items

  Scenario: Add Biba Product to Cart
    When I add the first "Biba" product to the cart
    Then I should see the brand success message "Your product has been added to cart."

  Scenario: View Cart from Biba Page
    When I add the first "Biba" product to the cart
    And I click "View Cart"
    Then I should be redirected to the cart page

  Scenario: Continue Shopping from Biba Page
    When I add the first "Biba" product to the cart
    And I click "Continue Shopping"
    Then I should remain on the "Biba" brand products page

  Scenario: Verify Biba Brand Navigation
    When I navigate to the home page
    And I select the "Biba" brand
    Then I should see the Biba brand products page

  Scenario: Verify Biba Product Count
    Then I should see at least one product

  Scenario: Verify Brand Sidebar Visibility on Biba Page
    Then I should see the brands sidebar

  Scenario: Navigate to another brand and back to Biba
    When I select the "Polo" brand
    And I select the "Biba" brand
    Then I should see the Biba brand products page

  Scenario: Verify Page URL for Biba
    Then the URL should contain "Biba"

  Scenario: Verify Header for Biba
    Then I should see the brand header "BRAND - BIBA PRODUCTS"
