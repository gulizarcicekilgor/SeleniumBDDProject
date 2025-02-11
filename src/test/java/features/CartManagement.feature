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
    ##Then User's cart should contain:
    ##  | Element        | Visible | Verified |
    ##  | Product name   | true    | true     |
    ##  | Product price  | true    | true     |
    ##  | Product quantity | true  | true     |

  #@cart @addAnother
  #Scenario: Add another product to shopping cart
  #  When User add another product to cart
  #  Then cart total price should equal products total price in cart
#
  ##@cart @price @calculation
  ##Scenario Outline: Validate cart total calculation
  ##  Given User have added <quantity> items to cart
  ##  When User view cart contents
  ##  Then the total price should equal product price multiplied by <quantity>
##
  ##  Examples:
  ##    | quantity |
  ##    | 2        |
  ##    | 3        |
  ##    | 5        |
##
  ##@cart @remove
  ##Scenario: Remove item from shopping cart
  ##  Given I have a product in my cart
  ##  When I remove the product from my cart
  ##  Then my cart should show "0 items"
  ##  And the product should not appear in cart contents