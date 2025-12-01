Feature: User Sign Up
  As a new user
  I want to sign up on the Automation Exercise website
  So that I can create a new account

  Background:
    Given I am on the home page
    And I navigate to the sign up page

  Scenario Outline: Sign up with various credentials
    When I enter name "<name>" and email "<email>"
    And I click the sign up button
    Then I should verify sign up status "<isValid>"

    Examples:
      | name       | email                  | isValid |
      | Steve      | steve123@gmail.com     | true    |
      |            | steve123@gmail.com     | false   |
      | Steve      |                        | false   |
      |            |                        | false   |
      | !@#$%     | invalidEmail           | false   |

  Scenario Outline: sign up valid credentials and fall information in Account page
    When  I enter name "AhmedMostafa" and email "Ahmed1234@gmail.com"
    And I click the sign up button
    Then I fill the account information with valid data "<gender>" "<firstName>" "<lastName>" "<email>" "<password>" "<day>" "<month>" "<year>" "<company>" "<address1>" "<address2>" "<country>" "<state>" "<city>" "<zipcode>" "<mobile>"



    Examples:
      | gender | firstName     | lastName           | email                  | password      | day | month | year  | company     | address1     | address2 | country | state   | city    | zipcode | mobile       |
      | male   | AhmedMostafa  | Ahmed              | Ahmed1234@gmail.com    | steve11223344 | 10  | 12    | 1997  | TestCorp    | Street 10    | Apt 5    | Canada  | Ontario | Toronto | 12345   | 01123456789 |
      | male   |               | Ahmed1234@gmail.com| steve11223344          | 123456        | 10  | 12    | 1997  | TestCorp    | Street 10    | Apt 5    | Canada  | Ontario | Toronto | 12345   | 01123456789 |
      | female | Sara          | Ahmed              | sara123@gmail.com      | saraPass123   | 15  | 05    | 1995  | SaraCorp    | Main St 5    | Apt 10   | USA     | Texas   | Dallas  | 54321   | 0123456789  |
      | male   | John          | Doe                | john.doe@gmail.com     | johnPass456   | 20  | 08    | 1990  | JD Inc      | Oak St 12    | Suite 3  | UK      | London  | London  | E1 6AN  | 0712345678  |
      | female |                | Smith              | smith@gmail.com        | pass1234      | 01  | 01    | 2000  | TestCo      | Elm St 8     | Floor 2  | Canada  | Quebec  | Montreal| H2X1Y2  | 0987654321  |
      | male   | Mike          | Tyson              | mike.tyson@gmail.com   | mikePass789   | 25  | 11    | 1985  | TysonCorp   | King St 20   | Apt 15   | USA     | Nevada  | Las Vegas| 88901  | 0111222333  |





  Scenario: Sign up with empty fields
    When I enter name "" and email ""
    And I click the sign up button
    Then I should verify sign up status "false"


