package amazon.pageobjects.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    /**
     * Wait for 10 seconds for presence of locator in DOM </br>
     * Wait for 10 seconds for html element to be clickable </br>
     * Once above two conditions are met then click on it
     * @param by locator
     */
    public void click(By by)
    {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        log.debug(by.toString()+" Element is present in DOM ");
        WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(by));
        log.debug(by.toString()+" Element is clickable ");
        ele.click();
        log.debug(by.toString()+" clicked ");

    }

    /**
     * wait for 10 second for presence of element
     * wait for 10 second for visibility of element and set text
     * @param by : locator
     * @param text : to be entered
     */
    public void setText(By by,String text)
    {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        log.debug(by.toString()+" locator is present in DOM ");
        WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        log.debug(by.toString()+" locator is visible in DOM ");
        ele.sendKeys(text);
        log.debug("Entered"+ text +" to "+ by.toString());
    }

    /**
     * wait for 20 seconds for locator to be present in DOM
     * and then return the text
     * @param by locator
     * @return String : text of Webelement
     */

    public String  getText(By by)
    {

        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(by));
        log.debug(" Element is present in the dom ");
        log.debug(" Text returned is "+ele.getText());
        return (ele.getText());

    }

    /**
     * Wait for 10 seconds for element to be present in the DOM
     * @param by : locator
     * @return true : if element is present in DOM ; false: if element is not present
     */

    public Boolean waitForPresenceOfElement(By by)
    {

        WebDriverWait wait = new WebDriverWait(driver,10);
        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            log.debug(by.toString()+" is present in the DOM ");
            return true;
        }catch (Exception e)
        {
            log.error(by.toString()+" is not present for 10 seconds ");
            return false;
        }

    }

    /**
     * wait 10 seconds for page to have a title
     * @param title : title of the page
     * @return true : if page has title ; false: if page doesn't have title
     */

    public Boolean waitForTitleToBe(String title)
    {
        WebDriverWait wait= new WebDriverWait(driver,10);
        try
        {
            wait.until(ExpectedConditions.titleIs(title));
            log.debug(" Title of the page updated to "+title);
            return  true;

        }catch (Exception e)
        {
            log.error(title +" Title is not present for 10 seconds ");
            return false;
        }
    }

    /**
     * Check for element for visibility first by checking for element presence
     * @param by locator
     * @return true: if element is visible with in 30 second else false
     *
     */
    public Boolean waitForElementToBeDisplayed(By by)
    {
        WebDriverWait wait= new WebDriverWait(driver,30);
        if(waitForPresenceOfElement(by))
        {

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                log.debug(by.toString()+" is visible ");
                return true;
            }catch (Exception e)
            {
             log.debug(by.toString() +" is visible ");
             return false;
            }
        }else
        {
            return false;
        }
    }
}
