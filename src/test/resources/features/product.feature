Feature: Product Page Functionality

  Scenario Outline:
    Given the home page has loaded
    When the more button of the product is clicked
    Given the product page has loaded
    When send to a friend button is clicked
    Then fill name of friend  with '<name>'
    And fill email of friend with '<email>'
    When the send button is clicked
    Then the '<feedback>' message should be shown
    Examples:
      | name           | email    | feedback                        |
      | random title   |          | You did not fill required fields|
      |                | Nothing  | You did not fill required fields|
      | random title   | Nothing  |                                 |

  Scenario Outline:
    Given the home page has loaded
    And the user is already signed in
    Given the home page has loaded
    When the more button of the product is clicked
    Then write review button is clicked
    Then title field is filled with '<title>' and comment field is filled with '<comment>'
    When the send review button is clicked
    Then the '<comment_error>' and '<title_error>'error message should be shown
    Examples:
      | title          | comment  | comment_error         |title_error|
      | random title   |          | Comment is incorrect  |           |
      |                | Nothing  |                       |Title is incorrect   |
      |                |          | Comment is incorrect  |Title is incorrect|
