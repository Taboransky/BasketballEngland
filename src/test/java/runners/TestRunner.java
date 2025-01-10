package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/output/cucumber.html",
                "json:target/output/cucumber.json"
        }
)

public class TestRunner {
}