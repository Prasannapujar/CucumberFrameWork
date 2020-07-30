package stepdefinition;

import amazon.pageobjects.authentication.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

public class LoginPageStepDef extends TestBase{

    private Logger log= LogManager.getLogger(LoginPageStepDef.class);
    private TestBase base;
    public  LoginPageStepDef(TestBase base)
    {
        this.base=base;
    }

  @Then("SignInPage should be displayed")
    public  void SignIn_page_shouldbe_displayed() throws  Exception
  {
      try
      {
          LoginPage lp= new LoginPage(base.driver);
          Assert.assertTrue(lp.waitForLoginPage(), " wait for login page");
          base.scenario.log(" Signin page is displayed ");
      }catch(Exception e)
      {
          log.error(" problem in step SignInPage should be displayed");
          e.printStackTrace();
          throw  new Exception();
      }

  }

    @Given("^user enter Email id as (.*)$")
    public void userEnterEmailIdAs(String  email) throws  Exception {
        try
        {
            LoginPage lp= new LoginPage(base.driver);
            lp.enterEmailId(email);
            base.scenario.log(" Email id is entered");
        }catch (Exception e)
        {
            log.error(" problem in step user enter Email id as {string}");
            e.printStackTrace();
            throw  new Exception();

        }
    }

    @When("^user enter password as (.*)$")
    public void userEnterPasswordAsPmpAmazon$(String pwd) throws  Exception {

        try
        {
            LoginPage lp= new LoginPage(base.driver);
            lp.enterPassword(pwd);
            base.scenario.log(" password entered ");
        }catch (Exception e)
        {
            log.error(" problem in step user enter Email id as {string}");
            e.printStackTrace();
            throw  new Exception();

        }
    }

}
