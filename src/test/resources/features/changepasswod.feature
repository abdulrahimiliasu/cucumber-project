Feature: Search Product Feature

  Background:
    Given the home page has loaded
    Given the user is signed in
    When the user account button is clicked

  Scenario Outline:
    And then click on your personal information button
    Then fill the old password with '<old_password>'
    And fill the new password with '<new_password>'
    And fill the confirmation with '<confirmation>'
    When the save button is clicked
    Then the '<message>' error message should appear
    Examples:
    | old_password | new_password | confirmation | message      |
    |             |               |              |The password you entered is incorrect.|
    |             |  12345678     |12345678      |The password you entered is incorrect.|
    | 12345678    |  12345678     |              |The password and confirmation do not match.|
    | pfpkfeoef   |  12345678     |12345678      |The password you entered is incorrect.|
    | foenfeof    |  foenfeof     |oneffeof      |The password you entered is incorrect.|
    | 12345678    |  o2oooe33     |3no3o3n3      |The password and confirmation do not match.|

  Scenario Outline:
    And then click on your personal information button
    Then fill the old password with '<old_password>'
    And fill the new password with '<new_password>'
    And fill the confirmation with '<confirmation>'
    When the save button is clicked
    Then the '<message>' success message should appear
    Examples:
      | old_password | new_password | confirmation | message      |
      |12345678     |               |              |Your personal information has been successfully updated.|
      | 12345678    |  12345678     |12345678      |Your personal information has been successfully updated.|