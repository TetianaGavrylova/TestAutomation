@REST
Feature: Test4

  Scenario Outline: Test4.1
    Given check on <error> for <name>
    Then check media <type> for name
    And check content <content> for name
    Examples:
    | error |    name  |     type        |     content    |
    |  200  |  Igor    |application/json |is "Igor Schwarzmann"|
    |  404  |Igor777777|application/html |is "Igor Schwarzmann"|
    |  200  |Igor777777|application/json |is "Igor Schwarzmann"|
    |  200  |  Igor    |application/json |is "Igor Glks"       |