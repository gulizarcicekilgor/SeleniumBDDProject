Feature: Shopping Cart Management
  As a customer
  User want to manage her/his own shopping cart
  So User can control purchase selections

  Background:
    Given User have searched for "kablosuz kulaklık" and selected a product

  @cart @add
  Scenario: Add product to shopping cart
    When User add the product to cart
    Then  User's cart should contain:
    #Then Price should equal to cart price
    When User add multiple product to cart
    Then cart total price should equal products total price in cart
    When User delete last product in cart
    Then cart total price should equal products total price in cart