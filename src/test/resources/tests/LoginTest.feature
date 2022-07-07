Feature: Testing logging of tested site

  Scenario Outline: User logs in at different pages of the tested site
    Given User is at Main page of the site
    When User click LogIn button
    And Type in Username <Username>
    And Type in Password <Password>
    And User finish logging in, click on LogIn button
    Then User must be logged in
    Examples:
      | Username            | Password |
      | Oleksii.Chernetskyi | qwert    |


