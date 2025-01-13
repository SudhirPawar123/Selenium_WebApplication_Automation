Feature: Login functionality
  Scenario: Validation of login for practice test automation webpage
    Given User is on login page
    When User Enter the Username as "Admin"
    And User enter Password as "admin123"
    And click on submit button