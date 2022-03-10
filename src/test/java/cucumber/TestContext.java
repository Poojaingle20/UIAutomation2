package cucumber;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {

    public RequestSpecification httpRequest;
    public Response response;
    public JsonPath jsonPath;
    public ScenarioContext scenarioContext;

    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    //   public TestContext(){
//        httpRequest= RestAssured.given();
//    }
    public RequestSpecification getRequestSpecification() {
        return httpRequest;
    }

    public Response getResponse() {
        return response;
    }

    public JsonPath getPath() {
        return jsonPath;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}

