package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * All step definition class will extend this class
 * Driver,scenario initialization happens @Before
 */
public class TestSetup {

    private Logger log = LogManager.getLogger(TestSetup.class);
    WebDriver driver;
    Scenario scenario;
    static String url;

    @Before
    public void setUp(Scenario scenario) throws IOException {
        this.scenario=scenario;
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        log.info(" Firefox driver is setup ");
        Properties properties= new Properties();
        FileInputStream fileInputStream= new FileInputStream("src/test/Setup.properties");
        properties.load(fileInputStream);
        url=properties.getProperty("Url");
        log.debug(" URL of the application is  "+url);
        driver.get(url);
        log.info(" Opening up the application with URL "+ url);
    }


    @After
    public void tearDown(Scenario s)
    {
        if(s.isFailed())
        {

        }
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
