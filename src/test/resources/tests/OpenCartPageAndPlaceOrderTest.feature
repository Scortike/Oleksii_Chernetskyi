Feature: Testing Cart page and Place Order button

  Scenario: User opens Cart page
    Given User selected "Dell i7 8gb" product
    When User clicks Cart button on the menu bar
    Then Cart page opens with correct url

  Scenario: User is at the Cart page and clicks Place Order button
    Given User is at Cart page
    When User clicks Place Order button
    Then Place Order form appears