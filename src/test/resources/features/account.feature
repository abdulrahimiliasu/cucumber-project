Feature: User Account Feature

  Background:
    Given the home page has loaded
    And the user is signed in
    When the go to user account button is clicked

  Scenario:
    When the order and history detail button is clicked
    Then the "Here are the orders you've placed since your account was created." text should be shown.

  Scenario:
    When the my credit slips button is clicked
    Then the "You have not received any credit slips." message should be shown.

  Scenario:
    When the my address button is clicked
    Then the "Debrecen Hungary" address should be there
