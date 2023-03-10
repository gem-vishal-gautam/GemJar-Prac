Feature: Swag Labs Automation

  Scenario Outline: Launch SauceDemo, perform login.
    Given user enter <Username> and <Password> and logs in.
    Then user verifies the url
    Then user checks the product and adds to cart
    And verifies the product in the cart
    Then user goes back to continue shopping
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |


  Scenario Outline: Launch SauceDemo, validate the text-content
    Given user enter <Username> and <Password> and logs in.
    Then user checks the product quantity
    And user verifies the text of a product <expectedProduct>, <expectedDetails>
    Examples:
      | Username      | Password     | expectedProduct       | expectedDetails                                |
      | standard_user | secret_sauce | Sauce Labs Bike Light | A red light isn't the desired state in testing |


  Scenario Outline: Launch SauceDemo, Checkout the product
    Given user enter <Username> and <Password> and logs in.
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |