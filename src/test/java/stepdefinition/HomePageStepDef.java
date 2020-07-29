package stepdefinition;

import amazon.pageobjects.home.HomePage;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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

      }catch (Exception e)
      {
          e.printStackTrace();
          throw new Exception();
      }


    }
}
