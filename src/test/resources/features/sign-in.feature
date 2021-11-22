Feature: Sign in with Credentials feature

  Background:
    Given the home page has loaded
    Given the Sign In page is opened

  Scenario Outline:
    Given the email address field is filled with '<email>'
    And the password field is filled with '<password>'
    When the Sign In button is clicked
    Then the '<error_message>' should be shown
    Examples:
      | email         | password | error_message             |
      | sdd@.2e.com   | 12345678 | Invalid email address.    |
      |               | 12345678 | An email address required.|
      | tom@gmail.com |          | Password is required.     |
      |               |          | An email address required.|
      | tom@gmail.com | 12345678 | Authentication failed.    |
      | tom@gmail.com | 1        | Invalid password.         |