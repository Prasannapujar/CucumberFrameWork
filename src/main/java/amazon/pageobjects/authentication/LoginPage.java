package amazon.pageobjects.authentication;

import amazon.pageobjects.common.BasePage;
import amazon.pageobjects.home.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represent the LoginPage when user hits the SignIn button on Header this page is displayed.
 */
public class LoginPage extends BasePage {

    private Logger log= LogManager.getLogger(LoginPage.class);
    private static By amazonImageAnchor= By.cssSelector(".a-link-nav-icon");
    private static By emailOrPhoneNumberInput=By.cssSelector("input.a-input-text.a-span12.auth-autofocus.auth-required-field");
    private static By continueInput=By.cssSelector("input[id='continue']");
    private static By passwordInput=By.cssSelector("input[name='password']");
    private static By loginInput=By.cssSelector("input[id='signInSubmit']");
    /**
     * Initialize the driver object
     *
     * @param driver : webdriver object
     * @author prasanna Pujar
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Wait for LoginPage to load by checking the amazon image and title of the page
     * @return true: if page is loaded ; false : if page is not loaded
     */
    public Boolean waitForLoginPage()
    {
      Boolean amazonImage= waitForElementToBeDisplayed(amazonImageAnchor);
      log.debug(" amazon image on LoginIn page is "+ amazonImage);
      Boolean title=waitForTitleToBe("Amazon Sign In");
      log.debug(" Title of the is loaded "+title);
      if(amazonImage && title)
      {
          log.info(" Login page is loaded ");
          return true;
      }else
      {
          log.warn(" Login page is not loaded ");
          return false;
      }

    }

    /**
     * Set the emailOrPhoneNumberInput field with email and click on continue
     * @param email : to be set
     * @return : LoginPage
     */
    public LoginPage enterEmailId(String email)
    {
      setText(emailOrPhoneNumberInput,email);
      log.info("Entered Email id " +email + " emailOrPhoneNumberInput Filed " );
      click(continueInput);
      log.info(" clicked on continue button ");

      return this;
    }

    /**
     *Enter the password and click on Login button
     * @param password
     * @return
     */
    public LoginPage enterPassword(String password)
    {
      setText(passwordInput,password);
      log.info(" Set password to the password field");
      click(loginInput);
      log.info(" clicked on Login button ");

      return this;
    }

    /**
     * Objective is to tperform valid login via this method
     * @param email Emaild ID
     * @param password password
     * @return HomePage
     */
    public HomePage performValidLogin(String email,String password)
    {
        enterEmailId(email)
                .enterPassword(password);
        return new HomePage(driver);


    }
}
