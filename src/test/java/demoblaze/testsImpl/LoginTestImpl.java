package demoblaze.testsImpl;

import core.BaseSeleniumTest;
import demoblaze.Page.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTestImpl extends BaseSeleniumTest
{
    MainPage page;
    @When("User click LogIn button")
    public void userClickLogInButton()
    {
        this.page.clickLogInButtonOnPage();
    }

    @And("^Type in Username ([^\"]*)$")
    public void typeInUsernameUsername(String username)
    {
        this.page.fillUsername(username);
    }

    @And("^Type in Password ([^\"]*)$")
    public void typeInPasswordPassword(String password)
    {
        this.page.fillPassword(password);
    }

    @And("User finish logging in, click on LogIn button")
    public void userFinishLoggingInClickOnLogInButton()
    {
        this.page.clickLogInButton();
    }

    @Then("User must be logged in")
    public void userMustBeLoggedIn()
    {
        Assert.assertTrue(this.page.isLoggedIn());
        this.tearDown();
    }

    @Given("User is at Main page of the site")
    public void userIsAtMainPageOfTheSite()
    {
        this.setUp();
        this.page = new MainPage();
    }
}
