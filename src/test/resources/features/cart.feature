Feature: Cart Checkout Feature

  Background:
    Given the home page has loaded

  Scenario:
    Given the user is signed in
    And cart button is clicked
    Given the shopping cart is empty
    Then a "Your shopping cart is empty." message should be displayed.

  Scenario:
    Given the user added items to the cart
    And proceed to checkout button is clicked
    When the proceed button is clicked
    Then the second proceed button is clicked
    When check the terms and conditions
    Then the third proceed button is clicked
    When pay by check button is clicked
    Then I confirm order button should be clicked
    And "Your order on My Store is complete." message should be shown.
