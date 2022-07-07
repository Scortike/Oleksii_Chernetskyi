package demoblaze.testsImpl;

import core.BaseSeleniumTest;
import demoblaze.Page.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import readProperties.ConfigProvider;

public class ChooseCategoryTestImpl extends BaseSeleniumTest {
    MainPage page;
    @Given("User is logged in at Home Page")
    public void userIsAtHomePage()
    {
        this.setUp();
        page = new MainPage();
        page.login(ConfigProvider.TEST_USERNAME, ConfigProvider.TEST_PASSWORD);
    }

    @When("User clicks on the Category Laptops button")
    public void userClicksOnTheCategoryButton()
    {
        page.clickLaptopsCategory();
    }

    @Then("Products on the home page must be changed")
    public void productsOnTheHomePageMustBeChanged()
    {
        Assert.assertTrue(this.page.getPageURL().contains("#"));
        this.tearDown();
    }
}
