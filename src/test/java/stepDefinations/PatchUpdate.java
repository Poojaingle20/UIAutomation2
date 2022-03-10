package stepDefinations;

import cucumber.TestContext;
import dataProvider.ConfigFileReader;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Method;
import org.json.JSONObject;

import static enums.Context.NAME;

public class PatchUpdate {
    TestContext testContext ;
    public PatchUpdate(TestContext context){
        testContext=context;
    }
    @When("The user passes {string} and {string} to request body for Login API")
    public void passingRequestBodyToUpdate(String name,String job){
        JSONObject jsonBody=new JSONObject();
        jsonBody.put(name, "morpheus");
        testContext.scenarioContext.setContext(NAME,"morpheus");
        jsonBody.put(job,"zion resident");
        testContext.httpRequest.body(jsonBody.toString());
        Header content=new Header("Content-Type","application/json");
        testContext.httpRequest.header(content);
        // ScenarioContext.Current.Add("PageTitle", "Scenario Context in Specflow");

    }

    @When("The user is hitting the request to endpoint with Patch API")
    public void the_User_is_hitting_the_request_to_the_endpoint_using_patch_API(){
        testContext.response=testContext.httpRequest.request(Method.PATCH);
        String name = (String)testContext.scenarioContext.getContext(NAME);
        // Assert.assertTrue(testContext.response.prettyPrint().contains(name));
        if(testContext.response.prettyPrint().contains(name)){
            System.out.println("Validated Successfully ..........");
        }
        else
            System.out.println("Validation Failed ...............");
    }
}
