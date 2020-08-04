package testrunner;

import Utility.Report;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

@CucumberOptions(
        glue = {"stepdefinition"},
        features = {"src/test/resources"},
        monochrome = true,
        plugin =  {"pretty", "html:target/cucumber","json:target/firefox1.json"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void aftersuite()
    {
        try {
            Report.generateDemoReport();
            System.out.println("Generated reports");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
