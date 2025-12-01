Feature: Madame Brand Functionality
  As a user
  I want to view Madame products
  So that I can purchase them

  Background:
    Given I am on the home page
    And I select the "Madame" brand

  Scenario: Verify Madame Page Title
    Then I should see the Madame brand products page
    And I should see "Madame" brand items

  Scenario: Add Madame Product to Cart
    When I add the first "Madame" product to the cart
    Then I should see the brand success message "Your product has been added to cart."

  Scenario: View Cart from Madame Page
    When I add the first "Madame" product to the cart
    And I click "View Cart"
    Then I should be redirected to the cart page

  Scenario: Continue Shopping from Madame Page
    When I add the first "Madame" product to the cart
    And I click "Continue Shopping"
    Then I should remain on the "Madame" brand products page

  Scenario: Verify Madame Brand Navigation
    When I navigate to the home page
    And I select the "Madame" brand
    Then I should see the Madame brand products page

  Scenario: Verify Madame Product Count
    Then I should see at least one product

  Scenario: Verify Brand Sidebar Visibility on Madame Page
    Then I should see the brands sidebar

  Scenario: Navigate to another brand and back to Madame
    When I select the "Polo" brand
    And I select the "Madame" brand
    Then I should see the Madame brand products page

  Scenario: Verify Page URL for Madame
    Then the URL should contain "Madame"

  Scenario: Verify Header for Madame
    Then I should see the brand header "BRAND - MADAME PRODUCTS"
