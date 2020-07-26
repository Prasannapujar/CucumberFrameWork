package amazon.pageobjects.common;

import org.openqa.selenium.WebDriver;

/**
 * EveryPage which has accesses to the Headers and Footer will extend this page
 */
public class HeaderFooterPage extends BasePage{
    /**
     * Initialize the driver object
     *
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public HeaderFooterPage(WebDriver driver) {
        super(driver);
    }
}
