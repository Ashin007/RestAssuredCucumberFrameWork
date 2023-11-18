package cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\org\\example\\features",
        glue = {"org.example.stepdefinitions"},
        plugin = "json:target/jsonReports/cucumber-report.json"
        //tags = "@GetPhoneUsingId" // or can be used for multiple tags
)
public class TestRunner {
}
