Feature: Shopping Cart Functionality
  As a user
  I want to manage my shopping cart
  So that I can purchase the items I want

  Background:
    Given I am on the home page
    And I have added products to the cart

  Scenario: Verify Cart Page Title
    When I navigate to the cart page
    Then I should see the cart page title "Shopping Cart"

  Scenario: Proceed to Checkout
    When I navigate to the cart page
    And I click "Proceed To Checkout"
    Then I should be redirected to the checkout page or login page

  Scenario: Remove Item from Cart
    When I navigate to the cart page
    And I remove an item from the cart
    Then the item should be removed from the cart

  Scenario: Register or Login from Cart
    When I navigate to the cart page
    And I click "Register / Login"
    Then I should be redirected to the login page
