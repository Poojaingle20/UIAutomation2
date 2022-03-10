Feature: check if the response is empty using Get API Call
  @RegressionTest
  Scenario: The user wants to update details and validate the status code and response for the list of users using PlistUsers API
    Given The user define the API Endpoint for "SingleUserNotFound" API
    When The user creates a request
    And The user is hitting the request to endpoint
    Then The user validate the status code as 404

