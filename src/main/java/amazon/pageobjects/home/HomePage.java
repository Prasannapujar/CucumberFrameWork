package amazon.pageobjects.home;


import amazon.pageobjects.common.HeaderFooterPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This page represent the Landing page when you hit amazon.in <br/>
 * This page has methods to handle logged and non logged in scenario
 * @author prasanna pujar
 */
public class HomePage extends HeaderFooterPage {
  private Logger log= LogManager.getLogger(HomePage.class);
  private static final By amazonLogoAnchor=By.cssSelector("a[href='/ref=nav_logo']");
  private static final By completePageDiv=By.id("pageContent");


    /**
     * Initialize the driver object
     *
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * wait for Home page load by waiting till amazon logo on top left corner to load
     * and main Div to the page to be loaded up in DOM
     * max time : 30 seconds
     * @return : true : if HomePage loads up else false
     */

    public Boolean waitForHomePageToLoad()
    {
        Boolean amazonImage=waitForElementToBeDisplayed(amazonLogoAnchor);
        log.debug(" amazonImage is displayed "+amazonImage);
        Boolean completePage=waitForPresenceOfElement(completePageDiv);
        log.debug(" Complete page is loaded in DIV ");
        if(amazonImage && completePage)
        {
            log.info(" HomePage has loaded ");
            return true;
        }else
        {
            log.warn(" HomePage not loaded up yet");
            return false;
        }
    }


}
