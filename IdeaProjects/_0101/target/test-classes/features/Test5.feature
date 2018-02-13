@apache
Feature: Test5

  Scenario: ApacheJmeter
    Given run jmeter
    Then check elapsed max 16 and average 500