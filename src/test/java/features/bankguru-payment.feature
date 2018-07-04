@payment
Feature: PAYMENT
  I want to run scenario so well...

  Scenario: [PAYMENT -] CREATE NEW ACCOUNT
    Given I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button
    And I get to username information
    And I get to password information

  Scenario: [PAYMENT -] LOGIN WITH INFOMATION
    Given I open login page
    When I input to username textbox
    And I input to password textbox
    And I submit button
    Then I verify homepage welcome message displayed

  Scenario Outline: [PAYMENT -] CREATE NEW CUSTOMER
    Given I click to New Customer Page
    And I input all information in this page
      | Customer   | Gender   | DateOfBirth   | Address   | City   | State   | PIN   | Phone   | Email   | Password   |
      | <Customer> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <PIN> | <Phone> | <Email> | <Password> |
    And I click sub button
    Then I verify all information
      | Customer   | Gender   | DateOfBirth   | Address   | City   | State   | PIN   | Phone   | Email   | Password   |
      | <Customer> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <PIN> | <Phone> | <Email> | <Password> |

    Examples: 
      | Customer    | Gender | DateOfBirth | Address | City  | State | PIN    | Phone      | Email   | Password |
      | Khanh Trang | f      | 28/06/1995  | HBT     | Hanoi | VN    | 123456 | 0163842125 | trangdk |   123456 |
