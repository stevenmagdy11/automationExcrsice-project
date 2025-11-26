Feature: Brand Products
  As a user
  I want to browse products by brand
  So that I can find items from my favorite brands

  Background:
    Given I am on the home page
    And I navigate to the products page

  Scenario: View Polo Brand Products
    When I select the "Polo" brand
    Then I should see the Polo brand products page
    And I should see "Polo" brand items

  Scenario: Add Polo Brand Product to Cart
    When I select the "Polo" brand
    And I add the first Polo product to the cart
    Then I should see the success message "Your product has been added to cart."

  Scenario: View Cart from Brand Page
    When I select the "Polo" brand
    And I click "View Cart"
    Then I should be redirected to the cart page

  Scenario: Continue Shopping from Brand Page
    When I select the "Polo" brand
    And I add the first Polo product to the cart
    And I click "Continue Shopping"
    Then I should remain on the Polo brand products page
