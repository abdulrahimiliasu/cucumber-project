Feature: Contact Us Feature

  Background:
    Given the home page has loaded
    When contactus button is clicked

  Scenario Outline:
    Then the '<subject>' subject heading is selected
    And the email field is filled with '<email>'
    And the order reference field is filled with '<order>'
    And the message field is filled with '<msg>'
    When the Send button is clicked
    And the '<error_message>' should be shown to user
    Examples:
      |subject                | email         | order    |msg     | error_message               |
      | Customer service      | sdd@.2e.com   | 12345678 |        |Invalid email address.       |
      | Webmaster             |               | 12345678 |        |Invalid email address.       |
      | -- Choose --          | tom@gmail.com |          |        |The message cannot be blank. |
      | Webmaster             |               |          |        |Invalid email address.       |
      | Customer service      | tom@gmail.com | 12345678 |        |The message cannot be blank. |
      | Customer service      | tom@gmail.com | 122      | Hello  |Your message has been successfully sent to our team.|

  Scenario:
    Then the "Customer service" subject heading is selected
    And the email field is filled with "tom@gmail.com"
    And the order reference field is filled with "122"
    And the message field is filled with "Hello"
    When the Send button is clicked
    And the "Your message has been successfully sent to our team." success message should be shown to user