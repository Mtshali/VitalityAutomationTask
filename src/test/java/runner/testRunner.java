package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features//weatherResult.feature"},
        glue = {"seleniumGlueCode"}
)

public class testRunner {

}
