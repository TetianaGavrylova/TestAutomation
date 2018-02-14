@SOAP
Feature: Test3

  Scenario Outline: Test3.1
    And Check SOAP with <text>
    And Check amount of mistakes <ExpectedMistakes>
    Then Check that there is the right word <RightWord>
    Examples:
    |   text        |ExpectedMistakes|RightWord|
    |Hellio         |     1          |Hello    |
    |Hellio brathher|     2          |brother  |
    |Hello World    |     0          |         |
    |Hello World    |     1          |         |
    |Hellio         |     1          |1 |
