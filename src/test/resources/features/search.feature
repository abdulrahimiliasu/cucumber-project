Feature: Search Product Feature

  Background:
    Given the home page has loaded

  Scenario Outline:
    Given the search field is filled with '<parameter>'
    When the Search button is clicked
    Then confirm the '<msg>' help message is shown
    And the search result should be '<result_text>'
    Examples:
      | parameter   | msg                                             | result_text               |
      |             | Please enter a search keyword                   |0 results have been found. |
      | nothing     | No results were found for your search "nothing" |0 results have been found. |
      | dress       |                                                 |7 results have been found. |
      | blouse      |                                                 |1 result has been found.   |
      | ebbe        | No results were found for your search "ebbe"    |0 results have been found. |
      | t-shirts    |                                                 |1 result has been found.   |