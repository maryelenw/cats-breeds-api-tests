Feature: Cat Breeds

  @regression @catBreeds
  Scenario: validate successful retrieval of cat breeds
    Given I send a GET request to "/breeds"
    Then the response status code should be 200
    And the response body should contain a list of cat breeds

  @regression @catBreeds
  Scenario: validate response contains expected breed information
    Given I send a GET request to "/breeds"
    Then the response body should contain at least one breed with "breed", "country", "origin", "coat" and "pattern" fields

  @catBreeds
  Scenario: validate response is returning data according the limit
    Given I send a GET request to "/breeds?limit=10"
    Then the response body should contain a maximum of 10 cat breeds

  @catBreeds
  Scenario: validate invalid limit returns error
    Given I send a GET request to "/breeds?limit=-1"
    Then the response status code should be 404

    # this test is failing, API does not have this validation (bug)
  Scenario: validate a string limit returns error
    Given I send a GET request to "/breeds?limit=AA"
    Then the response status code should be 404
    And the response body should contain an error message

  @catBreeds
  Scenario: validate API handles large limit parameter successfully
    Given I send a GET request to "/breeds?limit=1000"
    Then the response status code should be 200
    And the response body should contain a maximum of 1000 cat breeds