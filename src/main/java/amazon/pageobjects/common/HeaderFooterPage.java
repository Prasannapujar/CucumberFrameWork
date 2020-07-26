package amazon.pageobjects.common;

import amazon.pageobjects.authentication.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * EveryPage which has accesses to the Headers and Footer will extend this page
 */
public class HeaderFooterPage extends BasePage{
   private Logger log= LogManager.getLogger(HeaderFooterPage.class);
    private static final By signInAccountListLink= By.cssSelector("a#nav-link-accountList");
    private static final By loggedInuserNameSpan=By.cssSelector("a#nav-link-accountList>div>span");

    /**
     * Initialize the driver object
     *
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public HeaderFooterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * click on SignInAccountListLink and return LoginPage
     * @return : Login page
     */
    public LoginPage clickSignInAccountListLink()
    {
      click(signInAccountListLink);
      log.info(" clicked on signInAccountList link");
      return new LoginPage(driver);
    }

    /**
     * Get the logged in username this is done by extracting the name portion in Header
     *
     * @return string : name of user logged in
     */
    public String getLoggedInUserName()
    {
        String text= getText(loggedInuserNameSpan);
        String name=text.split(",")[1].trim();
        log.info(" User Name is "+ name);
        return name;
    }
}
