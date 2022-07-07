Feature: Testing product selection at the home page of the tested site

  Scenario: User selects products after category selection
    Given User selects the Category Laptops button
    When User clicks on the Dell i7 8gb product title
    Then page of "Dell i7 8gb" product opens
