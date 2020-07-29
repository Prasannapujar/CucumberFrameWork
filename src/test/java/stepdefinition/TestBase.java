package stepdefinition;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver;
    protected Scenario scenario;
    protected String url;
    protected String environment;
    protected String browser;

}
