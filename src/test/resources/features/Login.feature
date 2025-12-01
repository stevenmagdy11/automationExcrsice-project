Feature: User Login
  As a user
  I want to log in to the Automation Exercise website
  So that I can access my account

  Background:
    Given I am on the home page website
    And I navigate to the login page

  Scenario Outline: Login with various credentials
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should verify login status "<isValid>"

    Examples:
      | email               | password    | isValid |
      | wrong@gmail.com     | steve123456 | false   |
      |                     | steve123456 | false   |
      | steve123@gmail.com  |             | false   |
      | steve123@gmail.com  | steve123456 | true    |



