Feature: Checkout Process
  As a registered user
  I want to complete the checkout process
  So that I can place my order

  Background:
    Given I am on the home page
    And I am logged in
    And I have added products to the cart
    And I navigate to the cart page
    And I click Proceed To Checkout


  Scenario: Place Order with Valid Payment Details

    When I enter payment details:

      | Name on Card | Card Number      | CVC | Expiration Month | Expiration Year |
      | Steve Jobs   | 4111111111111111 | 123 | 12               | 2025            |

    And I click Pay and Confirm Order
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"

  Scenario: Place Order with Invalid Payment Details

    When I enter payment details:
      | Name on Card | Card Number | CVC | Expiration Month | Expiration Year |
      | Invalid User | 0000        | 000 | 00               | 0000            |
    And I click Pay and Confirm Order


  Scenario: Verify Checkout Page Details
    Then I should see the address details
    And I should see the order review

  Scenario: Place Order and Delete Account
    When I enter payment details:
      | Name on Card | Card Number      | CVC | Expiration Month | Expiration Year |
      | Test User    | 4242424242424242 | 321 | 01               | 2030            |
    And I click Pay and Confirm Order
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"

