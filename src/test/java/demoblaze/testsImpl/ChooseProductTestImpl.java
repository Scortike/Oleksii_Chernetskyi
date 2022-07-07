package demoblaze.testsImpl;

import core.BaseSeleniumTest;
import demoblaze.Page.MainPage;
import demoblaze.Page.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import readProperties.ConfigProvider;
import org.junit.Assert;

public class ChooseProductTestImpl extends BaseSeleniumTest
{
    MainPage page;
    ProductPage productPage;
    @Given("User selects the Category Laptops button")
    public void userSelectsTheCategoryLaptopsButton()
    {
        this.setUp();
        page = new MainPage();
        page.login(ConfigProvider.TEST_USERNAME, ConfigProvider.TEST_PASSWORD)
                .clickLaptopsCategory();
    }

    @When("User clicks on the Dell i{int} {int}gb product title")
    public void userClicksOnTheDellIGbProductTitle(int arg0, int arg1)
    {
        productPage = page.clickDellItem();
    }

    @Then("page of {string} product opens")
    public void pageOfProductOpens(String productName) {
        Assert.assertEquals(productName, this.productPage.getProductName());
        this.tearDown();
    }
}
