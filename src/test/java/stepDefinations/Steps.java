package stepDefinations;

import cucumber.TestContext;
import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Steps {

    private static final String Base_URL ="https://reqres.in/api/users";
     //ConfigFileReader configFileReader = new ConfigFileReader();
    TestContext testContext ;
    public Steps(TestContext context){
        testContext=context;
    }


    @Given("The user define the API Endpoint for {string} API")
    public void the_user_define_the_API_Endpoint_for_ListUser_API(String str) {
        RestAssured.baseURI = Base_URL;

        switch (str){
            case "ListUsers":
                RestAssured.baseURI = ConfigFileReader.getInstance().getDataFromPropertyFile("url")+ConfigFileReader.getInstance().getDataFromPropertyFile("listUser");
                break;
            case "SingleUser":
                RestAssured.baseURI = ConfigFileReader.getInstance().getDataFromPropertyFile("url")+ConfigFileReader.getInstance().getDataFromPropertyFile("SingleUser");
                break;
            case "SingleUserNotFound":
                RestAssured.baseURI=ConfigFileReader.getInstance().getDataFromPropertyFile("url")+ConfigFileReader.getInstance().getDataFromPropertyFile("SingleUserNotFound");
                break;
            case "SingleResource":
                RestAssured.baseURI=ConfigFileReader.getInstance().getDataFromPropertyFile("url")+ConfigFileReader.getInstance().getDataFromPropertyFile("SingleResource");
                break;

        }
    }

    @When("The user creates a request")
    public void the_user_creates_a_request_for_Get_listUsers_API() {
        testContext.httpRequest = RestAssured.given();
    }

    @And("The user passes query parameter as {string} in the ListUsers API")
    public void enterQueryParam(String string){
        String[] splitStr = string.split("=");
        testContext.httpRequest.queryParam(splitStr[0],splitStr[1]);
    }

    @When("The user is hitting the request to endpoint")
    public void the_user_is_hitting_the_request_to_endpoint() {
        testContext.response = testContext.httpRequest.request(Method.GET);
    }

    @Then("The user validate the status code as {int}")
    public void the_user_validate_the_status_code_as(int code) {
        Assert.assertEquals(code,testContext.response.statusCode());
    }

    @Then("The user validate the response contain the list of users")
    public void the_user_validate_the_response_contain_the_list_of_users() {
        testContext.jsonPath = testContext.response.jsonPath();
        List mapDataObj = testContext.jsonPath.get("data");
        int size = mapDataObj.size();
        Assert.assertNotEquals(0,size);

    }

    @Then("The user validate if the single user is  returned response with length 1")
    public void the_user_validate_the_response() {
        testContext.jsonPath = testContext.response.jsonPath();
        Map<String,Object> mapDataObj = testContext.jsonPath.get("data");
        int valueId = (Integer)mapDataObj.get("id");
        Assert.assertEquals(2,valueId);
    }

    @Then("The user validate that the response contains updated details")
    public void the_user_validate_that_the_response_contains_updated_details() {
        testContext.jsonPath = testContext.response.jsonPath();

    }

}

