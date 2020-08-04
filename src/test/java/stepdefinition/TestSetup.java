package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * All step definition class will extend this class
 * Driver,scenario initialization happens @Before
 */
public class TestSetup extends TestBase {

    private Logger log = LogManager.getLogger(TestSetup.class);

     private TestBase base;
     public TestSetup( TestBase base)
     {
         this.base=base;
     }
    @Before
    public void setUp(Scenario scenario1) throws IOException {

       // String browser= Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("Browser");
        String name=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getName();
        log.debug(" Name of the current Test is"+name);
        Map<String,String> params=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getAllParameters();
        String browser=params.get("Browser");
        System.out.println(" size of the parameter is "+params.size());
        System.out.println(params);
//        for(Object o:params)
//        {
//            System.out.println(o.toString());
//        }
        String fileName="Logs"+File.separator+browser;
        File F= new File(fileName);
        if(!F.exists())
        {
            F.mkdirs();
        }
        ThreadContext.put("ROUTINGKEY",fileName);
        log.debug(" Thread Context is been set to "+fileName);
        log.debug(" Browser is "+browser);
        base.scenario=scenario1;

        if(browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            base.driver = new FirefoxDriver();
            log.info(" Firefox driver is setup ");

        }else  if (browser.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();

            base.driver = new EdgeDriver();
            log.info(" Edge driver is setup ");
        }else  if (browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();

            base.driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65530).build());
            log.info(" Chrome driver is setup ");
        }



        Properties properties= new Properties();
        FileInputStream fileInputStream= new FileInputStream("src/test/Setup.properties");
        properties.load(fileInputStream);
        base.url=properties.getProperty("Url");
        log.debug(" URL of the application is  "+base.url);
        base.driver.get(base.url);
        log.info(" Opening up the application with URL "+ base.url);

    }


    @After
    public void tearDown(Scenario s)
    {
        if(s.isFailed() && base.driver!=null)
        {
            Date date= new Date();
            String name=s.getId()+s.getName()+s.getLine()+ date.getTime();
            log.debug(" Filename is "+name);
          byte[] screenShoot= ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
          s.attach(screenShoot,"image/png",name);
          log.debug(" attached the screenshot");
        }
        if(base.driver!=null)
        {
            base.driver.quit();
            log.info(" closing the browser ");
        }
    }


}
