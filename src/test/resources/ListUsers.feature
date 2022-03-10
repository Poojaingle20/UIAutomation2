Feature: Get the list of users using Get API Call
  @RegressionTest
  Scenario: The user wants to validate the status code and response for the list of users using Get listUsers API
    Given The user define the API Endpoint for "ListUser" API
    When The user creates a request
    And The user passes query parameter as "page=2" in the ListUsers API
    And The user is hitting the request to endpoint
    Then The user validate the status code as 200
    And The user validate the response contain the list of users

