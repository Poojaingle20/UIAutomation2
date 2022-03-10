Feature: Get the Single Resources using Get API call
  @RegressionTest
  Scenario: The user want to validate the status code using single Resources  API
    Given The user define the API Endpoint for "SingleResources" API
    When  The user creates a request
    And The user is hitting the request to endpoint
    Then The user validate the status code as 200
