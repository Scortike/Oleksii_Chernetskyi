Feature: Testing adding product to cart at chosen product page

  Scenario: User adds selected product to the cart
    Given User on the "Dell i7 8gb" page
    When User clicks Add to cart button
    Then Must be alert about adding product to the cart