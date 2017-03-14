Feature: Login Verification

  @Smoke
  Scenario: Verification of Login
    Given I am on the login page
    When I enter username and password
    Then I should see the username