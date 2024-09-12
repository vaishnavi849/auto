Feature: Automation Exercise Login and Print product Details
 
  Scenario: Successful Login and print all product names and prices
    Given I am on the Automation Exercise login page
    When I login with valid credentials
    And I navigate to the products page
    Then I print all product names and prices
 
  