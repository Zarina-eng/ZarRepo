package StepDefinitions;

import Utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    // We have @before @After annotations.
    //Those are  coming from Cucumber.
    //They will run before and after each scenario
    //We  have one scenario interface to get the details from every scenario
    @Before
    public void setUp(Scenario scenario){
        System.out.println("This one will run before each scenario");
        System.out.println(scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("This one will run after each scenario");
        // after annotation will execute after each scenarios even through they are failed . undefined
        if(scenario.isFailed()) {
            scenario.log("log message");
            // LOG it  is like System.out.println
            //scenario.log(scenario.getName()+"is failed");
            BrowserUtils.takeScreenShot();
        }
        }
        @Before()
        public void conditionalAnnatotaion (Scenario scenario){
            System.out.println("gkhfljdf");


        }

}
