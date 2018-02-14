@apache
Feature: Test5

  Scenario Outline: ApacheJmeter
    Given run jmeter for <users> users and <loops> loops
    Then check elapsed max 1600 and average 700
    Examples:
      |users  |loops|
      |   5   |  3  |
      |  14   |  4  |
      |  100  |  5  |