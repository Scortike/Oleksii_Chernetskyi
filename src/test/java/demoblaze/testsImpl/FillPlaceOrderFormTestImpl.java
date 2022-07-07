package demoblaze.testsImpl;

import core.BaseSeleniumTest;
import demoblaze.Page.CartPage;
import demoblaze.Page.MainPage;
import demoblaze.Page.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import readProperties.ConfigProvider;

public class FillPlaceOrderFormTestImpl extends BaseSeleniumTest {
    MainPage page;
    ProductPage productPage;
    CartPage cartPage;
    @Given("User is at cart page and Place Order form is opened in the Chrome browser")
    public void userIsAtCartPageAndPlaceOrderFormIsOpenedInTheChromeBrowser()
    {
        this.setUp();
        page = new MainPage();
        cartPage = page.login(ConfigProvider.TEST_USERNAME, ConfigProvider.TEST_PASSWORD)
                .clickLaptopsCategory()
                .clickDellItem()
                .addToCart()
                .clickCart()
                .clickPlaceOrder();
    }

    @And("Clicks Purchase button")
    public void clicksPurchaseButton()
    {
        cartPage.clickPurchaseOrder();
    }

    @Then("Confirming window appears$")
    public void confirmingWindowAppears()
    {
        Assert.assertTrue(cartPage.isPlaceOrderShows());
        this.tearDown();
    }


    @When("Types in name field {string}")
    public void typesInNameField(String name)
    {
        cartPage.fillNameInput(name);
    }

    @And("Types in country field {string}")
    public void typesInCountryField(String country)
    {
        cartPage.fillCountryInput(country);
    }

    @And("Types in city field {string}")
    public void typesInCityField(String city)
    {
        cartPage.fillCityInput(city);
    }

    @And("Types in credit card field {string}")
    public void typesInCreditCardField(String card)
    {
        cartPage.fillCreditCardInput(card);
    }

    @And("Types in month field {string}")
    public void typesInMonthField(String month)
    {
        cartPage.fillMonthInput(month);
    }

    @And("Types in year field {string}")
    public void typesInYearField(String year)
    {
        cartPage.fillYearInput(year);
    }
}
