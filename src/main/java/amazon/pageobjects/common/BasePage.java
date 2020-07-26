package amazon.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


/** Every PageObject class should implement this class </br>
 * This is where initialization of driver in page class happen
 *
 * @author Prasanna Pujar
  */
public class BasePage {
   private Logger log= LogManager.getLogger(BasePage.class);
    protected WebDriver driver;


    /**
     * Initialize the driver object
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public BasePage(WebDriver driver) {

        this.driver = driver;
        log.debug(" Base page driver got initialized ");
    }
}
