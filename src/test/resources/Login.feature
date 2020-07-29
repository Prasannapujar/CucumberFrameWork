Feature: Login
  covering the scenarios like valid login using correct email ID and password
  Invalid login using invalid email id and invalid password

  Scenario: Valid login
    Given user is at HomePage of amazon
    When  User clicks of SignInTab
    Then SignInPage should be displayed
    Given user enter Email id as <prasannapujar46@gmail.com>
    When user enter password as <Pmp4amazon$>
    Then User should Redirected to HomePage
    And User Name <prasanna> should be displayed at the Headers


