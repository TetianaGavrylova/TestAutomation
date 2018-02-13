@apache
Feature: Test5

  Scenario: ApacheJmeter
    Given run jmeter
    Then check elapsed max 1600 and average 500