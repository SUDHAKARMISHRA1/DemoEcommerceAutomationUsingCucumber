package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features="src/test/java/features",glue = {"stepDefinitions"},
monochrome=true, tags = "@RegressionSuit", plugin = {"json:target/jsonReports/cucumber-report.json"})
public class TestRunner extends AbstractTestNGCucumberTests{


}