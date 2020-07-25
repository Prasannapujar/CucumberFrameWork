package amazon.pageobjects;

import org.openqa.selenium.WebDriver;

/** Every PageObject class should implement this class </br>
 * This where initialization of driver in page class happen
 *
 * @author Prasanna Pujar
 *
 * 
 *
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
