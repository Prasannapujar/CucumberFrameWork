package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepdefinition"},
        features = {"src/test/resources"},
        monochrome = true,
        plugin =  {"pretty", "html:target/cucumber","json:target/report.json"}

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
