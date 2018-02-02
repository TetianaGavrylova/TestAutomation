#@tag1
Feature: Test1

    Scenario: Test1
      Given open browser
      And go to https://www.google.cz/
      And Enter search word panda wiki
      When Do search
      Then Click on link
      And Enter data
      |User|Pas|123|
      And Close browser

#      Scenario Outline: Test2
#        Given open browser
#        And go to <URL>
#        And Enter search word <Search>
#        Then Do search
#        And Close browser
#        Examples:
#        |URL|Search|
#        |https://www.google.cz/|panda|
#        |https://www.google.cz/|fox|
#        |https://www.wikipedia.org/|building|