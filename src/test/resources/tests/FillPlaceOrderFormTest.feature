Feature: Testing filling up the place order form and Purchase button

  Scenario: User fills up Place Order form
    Given User is at cart page and Place Order form is opened in the Chrome browser
    When Types in name field "Oleksii Chernetskyi"
    And Types in country field "Ukraine"
    And Types in city field "Kyiv"
    And Types in credit card field "0000000000000000"
    And Types in month field "7"
    And Types in year field "2022"
    And Clicks Purchase button
    Then Confirming window appears