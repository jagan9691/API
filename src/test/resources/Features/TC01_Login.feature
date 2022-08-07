Feature: Login Module API Automation

  @login
  Scenario Outline: User get Logtoken from endpoints.
    Given User add Header
    And User add basic Authentication "<username>","<password>"for login
    When User send POST request for Loginendpoint
    Then User verify the status code is 200
    And User verify the login response body firstname is ""and save the login token.

    Examples: 
      | username            | password   |
      | jagan9691@gmail.com | Jagan@1997 |
