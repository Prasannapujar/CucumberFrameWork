package stepdefinition;

import amazon.pageobjects.home.HomePage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class HomePageStepDef extends TestBase {

    private Logger log= LogManager.getLogger(HomePageStepDef.class);
   private TestBase base;

    public  HomePageStepDef(TestBase base)
    {
        this.base=base;
    }

    @Given("user is at HomePage of amazon")
    public void user_is_at_home_page_of_amazon() throws Exception {
      try
      {
          HomePage hp= new HomePage(base.driver);
          Assert.assertTrue(hp.waitForHomePageToLoad(), " Wait for Home");
          base.scenario.log(" Home page is loaded up");

      }catch (Exception e)
      {
          log.error(" problem in step user is at HomePage of amazon ");
          e.printStackTrace();
          throw new Exception();
      }


    }


    @When("User clicks of SignInTab")
    public void user_clicks_of_sign_in_tab() throws Exception {
        try
        {
            HomePage hp =new HomePage(base.driver);
            hp.clickSignInAccountListLink();
            base.scenario.log(" clicked on Sign in account link");

        }catch (Exception e)
        {
            log.error(" Problem in step User clicks of SignInTab ");
            e.printStackTrace();
            throw new Exception();
        }

    }

    @Then("User should Redirected to HomePage")
    public void userShouldRedirectedToHomePage() throws  Exception {

        try
        {
            HomePage hp= new HomePage(base.driver);
            Assert.assertTrue(hp.waitForHomePageToLoad(), " Wait for Home");
            base.scenario.log(" Home page is loaded up");

        }catch (Exception e)
        {
            log.error(" problem in step user is at HomePage of amazon ");
            e.printStackTrace();
            throw new Exception();
        }
    }
}
