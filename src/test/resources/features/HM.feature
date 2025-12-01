Feature: H&M Brand Functionality
  As a user
  I want to view H&M products
  So that I can purchase them

  Background:
    Given I am on the home page
    And I select the "H&M" brand

  Scenario: Verify H&M Page Title
    Then I should see the H&M brand products page
    And I should see "H&M" brand items

  Scenario: Add H&M Product to Cart
    When I add the first "H&M" product to the cart
    Then I should see the brand success message "Your product has been added to cart."

  Scenario: View Cart from H&M Page
    When I add the first "H&M" product to the cart
    And I click "View Cart"
    Then I should be redirected to the cart page

  Scenario: Continue Shopping from H&M Page
    When I add the first "H&M" product to the cart
    And I click "Continue Shopping"
    Then I should remain on the "H&M" brand products page

  Scenario: Verify H&M Brand Navigation
    When I navigate to the home page
    And I select the "H&M" brand
    Then I should see the H&M brand products page

  Scenario: Verify H&M Product Count
    Then I should see at least one product

  Scenario: Verify Brand Sidebar Visibility on H&M Page
    Then I should see the brands sidebar

  Scenario: Navigate to another brand and back to H&M
    When I select the "Polo" brand
    And I select the "H&M" brand
    Then I should see the H&M brand products page

  Scenario: Verify Page URL for H&M
    Then the URL should contain "H&M"

  Scenario: Verify Header for H&M
    Then I should see the brand header "BRAND - H&M PRODUCTS"
