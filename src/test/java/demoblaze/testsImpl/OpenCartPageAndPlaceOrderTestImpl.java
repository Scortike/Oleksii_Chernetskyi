package demoblaze.testsImpl;

import core.BaseSeleniumTest;
import demoblaze.Page.CartPage;
import demoblaze.Page.MainPage;
import demoblaze.Page.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import readProperties.ConfigProvider;

public class OpenCartPageAndPlaceOrderTestImpl extends BaseSeleniumTest {
    MainPage page;
    ProductPage productPage;
    CartPage cartPage;

    @Given("User selected {string} product")
    public void userSelectedProduct(String productName)
    {
        this.setUp();
        page = new MainPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        productPage = page.login(ConfigProvider.TEST_USERNAME, ConfigProvider.TEST_PASSWORD)
                .clickLaptopsCategory()
                .clickDellItem();
        Assert.assertEquals(productName, this.productPage.getProductName());
        productPage.addToCart();
        Assert.assertTrue(this.productPage.getPageURL().contains("#"));
    }

    @When("User clicks Cart button on the menu bar")
    public void userClicksCartButtonOnTheMenuBar()
    {
        cartPage = productPage.clickCart();
    }

    @Given("User is at Cart page")
    public void userIsAtCartPage()
    {
        this.setUp();
        page = new MainPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        cartPage = page.login(ConfigProvider.TEST_USERNAME, ConfigProvider.TEST_PASSWORD)
                .clickLaptopsCategory()
                .clickDellItem()
                .addToCart()
                .clickCart();
    }

    @When("User clicks Place Order button")
    public void userClicksPlaceOrderButton()
    {
        cartPage.clickPlaceOrder();
    }

    @Then("Place Order form appears")
    public void placeOrderFormAppears()
    {
        Assert.assertTrue(cartPage.isPlaceOrderShows());
        this.tearDown();
    }

    @Then("Cart page opens with correct url")
    public void cartPageOpensWithCorrectUrl()
    {
        Assert.assertTrue(cartPage.getPageURL().contains("cart"));
        this.tearDown();
    }
}
