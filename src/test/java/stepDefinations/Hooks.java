package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenarioWithOrderOne(){
        System.out.println("This will run before the every Scenario");
        //testContext.httpRequest = RestAssured.given();

    }
    @After
    public void AfterScenarioWithOrderOne(){
        System.out.println("This will run after the every Scenario");
    }
}
