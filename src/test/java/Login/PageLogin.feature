Feature: Page Login
  As a user, I want to login with correct credentials.

  Background: Go to login page
    Given user is on the login page

  Scenario: Page login with correct credentials
    When entering the correct username and password
    Then the user is able to login

  Scenario: Page login with wrong credentials
    When entering the wrong credentials
    Then the user is not able to login