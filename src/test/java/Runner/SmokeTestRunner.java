package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "StepDefinitions",
        monochrome = false,
        dryRun = false,
        tags = {"@smoke","@negative"}

)
public class SmokeTestRunner {
    // i want to run all feature  file or scenario which  have a smoke Tag (annotation)















}
