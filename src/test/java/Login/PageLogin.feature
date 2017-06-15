Feature: Page Login
  As a user, I want to login with correct credentials.

  Background: Go to login page
    Given user is on the login page

  Scenario: Page login with correct credentials
    When entering the correct username "yevster" and password "green3000"
    Then the user is able to login

  Scenario Outline: Page login with wrong credentials
    When entering the wrong credentials for username "<username>" or password "<password>"
    Then the user is not able to login
    Examples:
    |username|password|
    |yevster |wrongPass|
    |wrongLogin|green3000|
    |wrongLogin|wrongPass|