package demoblaze.testsImpl;

import core.BaseSeleniumTest;
import demoblaze.Page.MainPage;
import demoblaze.Page.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import readProperties.ConfigProvider;

public class AddProductToCartTestImpl extends BaseSeleniumTest {
    MainPage page;
    ProductPage productPage;

    @Given("User on the {string} page")
    public void userOnThePage(String productName)
    {
        this.setUp();
        page = new MainPage();
        productPage = new ProductPage();
        page.login(ConfigProvider.TEST_USERNAME, ConfigProvider.TEST_PASSWORD)
                .clickLaptopsCategory()
                .clickDellItem();
        Assert.assertEquals(productName, this.productPage.getProductName());
    }

    @When("User clicks Add to cart button")
    public void userClicksAddToCartButton()
    {
        productPage.addToCart();
    }

    @Then("Must be alert about adding product to the cart")
    public void mustBeAlertAboutAddingProductToTheCart()
    {
        Assert.assertTrue(this.productPage.getPageURL().contains("#"));
        this.tearDown();
    }
}
