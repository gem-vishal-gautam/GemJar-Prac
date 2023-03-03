Feature: Swag Labs Automation

  Scenario Outline: Launch SauceDemo, perform login.
    Given user enter <Username> and <Password> and logs in.
    Then user checks the product and adds to cart
    And verifies the product in the cart
    Then user goes back to continue shopping
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

