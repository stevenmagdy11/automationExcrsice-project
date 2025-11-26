Feature: Product Categories
  As a user
  I want to browse product categories
  So that I can find specific items

  Background:
    Given I am on the home page
    And I navigate to the products page

  Scenario: Add Women Dress to Cart
    When I open the Women category
    And I select the Dress subcategory
    And I add the first dress to the cart
    Then I should see the success message "Your product has been added to cart."

  Scenario: Add Men Jeans to Cart
    When I open the Men category
    And I select the Jeans subcategory
    And I add the first jeans to the cart
    Then I should see the success message "Your product has been added to cart."

  Scenario: Add Kids Dress to Cart
    When I open the Kids category
    And I select the Kids Dress subcategory
    And I add the first kids dress to the cart
    Then I should see the success message "Your product has been added to cart."

  Scenario: Verify Category Navigation
    When I open the Men category
    And I select the T-shirts subcategory
    Then I should see the Men T-shirts products

