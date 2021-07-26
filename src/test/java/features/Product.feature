@LoginFeature
Feature: Product List Feature
  Discriprtion: Adding  item to the cart

  Background: 
    Given User is on the  SwagLab Application
    When Enters the username "standard_user"
    And Enters the password "secret_sauce"
    And User click on login button

  @PRoductFeatur
  Scenario Outline: Verify that usser is able to add single product to the cart.
    When User select the product "<Product>"
    Then User able to see the selected product in cart item

    Examples: 
      | Product             |
      | Sauce Labs Backpack |

  @Datatable
  Scenario: Verify that usser is able to add multiple product to the cart.
    When User select the list of product
      | Field    | Value                   |
      | Product1 | Sauce Labs Backpack     |
      | Product2 | Sauce Labs Bike Light   |
      | Product3 | Sauce Labs Bolt T-Shirt |
    Then User able to see the selected product in cart item
