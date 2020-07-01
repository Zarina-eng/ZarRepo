package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Pet/PetCreated.feature",
        glue="StepDefinition",
        monochrome=false,
        dryRun = false,
        tags="@api"


)

public class ApiRunner {
}
