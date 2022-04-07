Feature: User can buy clothes

  Scenario: User buy a sweater

    Given User open a browser on https://mystore-testlab.coderslab.pl/
    When User is logged in with correct data from Task one
    And User pick Hummingbird Printed T-shirt to buy
    And User pick size
    And User pick five pieces
    And User add product to the basket
    And User go to checkout option
    And User confirm address
    And User pick a pickup method PrestaShop pick up in store
    And User pick a payment method - Pay by Check
    And User click on order with an obligation to pay
    Then User take a screenshot with amount and order confirmation
    And WebBrowser is closed

