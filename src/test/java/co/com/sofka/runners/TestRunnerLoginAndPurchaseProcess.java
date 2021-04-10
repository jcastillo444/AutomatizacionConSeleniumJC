package co.com.sofka.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "co.com.sofka.stepdefinitions"
)
public class TestRunnerLoginAndPurchaseProcess {
}
