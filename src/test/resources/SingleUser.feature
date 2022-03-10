Feature: API functionality to Get the Single User
  @RegressionTest
  Scenario: The user validates whether the Single user is returned using get the Single User
    Given The user define the API Endpoint for "SingleUser" API
    When The user creates a request
    And The user is hitting the request to endpoint
    Then The user validate the status code as 200
    Then The user validate if the single user is  returned response with length 1
