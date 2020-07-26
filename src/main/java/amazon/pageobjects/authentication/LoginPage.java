package amazon.pageobjects.authentication;

import amazon.pageobjects.common.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Represent the LoginPage when user hits the SignIn button on Header this page is displayed.
 */
public class LoginPage extends BasePage {
    /**
     * Initialize the driver object
     *
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
