package runner;
//import cucumber.api.CucumberOptions;

import io.cucumber.junit.Cucumber;;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"./src/test/resources/features/SearchServices.feature","./src/test/resources/features/SearchWeb.feature"},
        glue = {"stepDefinitions"},
        plugin = { "pretty","html:target/cucumber-reports.html",
                "json:target/tradeMe.json" },
        monochrome = true
)
public class TestRunner {
}