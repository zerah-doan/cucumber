@ApiTest
Feature: Test api

  Scenario Outline: Verify all end point
    Given I test https://jsonplaceholder.typicode.com/ api
    When I request <endpoint> end point
    Then The response structure should be valid as <schema>
    And The response size should be <size>
    Examples:
      | endpoint | schema | size |
      | posts    | 1      | 100  |
      | comments | 2      | 500  |
      | albums   | 3      | 100  |
      | photos   | 4      | 5000 |
      | todos    | 5      | 200  |
      | users    | 6      | 10   |
