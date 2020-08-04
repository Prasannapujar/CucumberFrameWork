package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepdefinition"},
        features = {"src/test/resources"},
        monochrome = true,
        plugin =  {"pretty", "html:target/cucumber2","json:target/firefox2.json"}

)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}
