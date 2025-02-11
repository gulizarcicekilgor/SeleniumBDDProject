Feature: Product Details Display
  As a potential buyer
  User want to view product details
  So User can verify product information before purchasing

  @product @details
  Scenario: View product details from search results
    Given User have searched for "kablosuz kulaklık" and results are visible
    When User select the first product from the results
    Then the product details page should display:
      | Element           | Visible |
      | Product name      | true    |
      | Product price     | true    |
      | Availability text | true    |