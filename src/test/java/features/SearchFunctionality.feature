Feature: Product Search Functionality
  As an online shopper
  User want to search for products
  So  User can find items wish to purchase

  @search @smoke
  Scenario: Search for product and verify relevant results
    Given User on the homepage
    When User search for "kablosuz kulaklık"
    Then the search results should be displayed
    And results should contain text "kablosuz kulaklık"