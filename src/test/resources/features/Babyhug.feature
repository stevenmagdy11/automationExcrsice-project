Feature: Babyhug Brand Functionality
  As a user
  I want to view Babyhug products
  So that I can purchase them

  Background:
    Given I am on the home page
    And I select the "Babyhug" brand

  Scenario: Verify Babyhug Page Title
    Then I should see the Babyhug brand products page
    And I should see "Babyhug" brand items

  Scenario: Add Babyhug Product to Cart
    When I add the first "Babyhug" product to the cart
    Then I should see the brand success message "Your product has been added to cart."

  Scenario: View Cart from Babyhug Page
    When I add the first "Babyhug" product to the cart
    And I click "View Cart"
    Then I should be redirected to the cart page

  Scenario: Continue Shopping from Babyhug Page
    When I add the first "Babyhug" product to the cart
    And I click "Continue Shopping"
    Then I should remain on the "Babyhug" brand products page

  Scenario: Verify Babyhug Brand Navigation
    When I navigate to the home page
    And I select the "Babyhug" brand
    Then I should see the Babyhug brand products page

  Scenario: Verify Babyhug Product Count
    Then I should see at least one product

  Scenario: Verify Brand Sidebar Visibility on Babyhug Page
    Then I should see the brands sidebar

  Scenario: Navigate to another brand and back to Babyhug
    When I select the "Polo" brand
    And I select the "Babyhug" brand
    Then I should see the Babyhug brand products page

  Scenario: Verify Page URL for Babyhug
    Then the URL should contain "Babyhug"

  Scenario: Verify Header for Babyhug
    Then I should see the brand header "BRAND - BABYHUG PRODUCTS"
