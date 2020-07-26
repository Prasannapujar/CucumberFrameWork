package amazon.pageobjects.home;

import amazon.pageobjects.common.BasePage;
import amazon.pageobjects.common.HeaderFooterPage;
import org.openqa.selenium.WebDriver;

/**
 * This page represent the Landing page when you hit amazon.in <br/>
 * This page has methods to handle logged and non logged in scenario
 * @author prasanna pujar
 */
public class HomePage extends HeaderFooterPage {
    /**
     * Initialize the driver object
     *
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }
}
