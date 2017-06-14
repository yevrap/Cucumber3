Feature: Page Login
  As a user, I want to login with correct credentials.

  Scenario: Page login with correct credentials
    Given user is on the login page
    When entering the correct username and password
    Then the user is able to login

  Scenario: Page login with wrong credentials
    Given user is on login page
    When entering the wrong credentials
    Then the user is not able to login