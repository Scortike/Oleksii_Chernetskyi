Feature: Testing category selection at the home page of the tested site

  Scenario: User selects different categories at home page
    Given User is logged in at Home Page
    When User clicks on the Category Laptops button
    Then Products on the home page must be changed