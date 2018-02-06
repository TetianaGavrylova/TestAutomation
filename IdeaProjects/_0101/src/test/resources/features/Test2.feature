#@tag1
Feature: Test2

  Scenario: Test2.1
    Given open browser
    Then go to https://www.wikipedia.org/
    And Enter the search word wiki panda
    And Extract the page title
    And Compare actual result with expected Giant panda - Wikipedia
    Then Close browser

  Scenario: Test2.2
    Given open browser
    Then go to https://www.google.cz/
    And paste the page title
    And Do search
    Then Close browser