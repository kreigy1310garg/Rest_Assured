Feature: Pet Store Management
  I want to create a pet in the store

  Background: This is my common part from all scenarios in single feature
    Given I have the pet details ready with me.

  @dev
  Scenario: Creating a pet in store
    When I posted the requested to the "/pet" endpoint.
    Then Response should be 200.
    And Response should have pet breed as german.

  Scenario: Pet should not get created when I don't provide DTO.
    When I posted the requested to the "/pet" endpoint.
    Then Response should be 400.

  Scenario Outline: Same scenario with different data set <EndPoint>
    When I posted the requested to the "<EndPoint>" endpoint.
    Then Response should be <StatusCode>.

    Examples: 
      | EndPoint | StatusCode |
      | /pet     |        200 |
      | /test    |        404 |
