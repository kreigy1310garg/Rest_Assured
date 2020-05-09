Feature: Pet Store Management 2
 I want to create a pet in the store

@test
  Scenario: Creating a pet in store 2
    Given I have the pet details ready with me.
    When  I posted the requested to the "/pet" endpoint.
    Then  Response should be 200.
    And Response should have pet breed as german.
    