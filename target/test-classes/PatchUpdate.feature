Feature: Update the details of user using Patch API Call
  @RegressionTest

  Scenario: The user wants to update details and validate the status code and response for the list of users using PlistUsers API
    Given The user define the API Endpoint for "PatchUpdate" API
    When The user creates a request
    And  The user passes "name" and "job" to request body for Login API
    And The user is hitting the request to endpoint with Patch API
    Then The user validate the status code as 200

