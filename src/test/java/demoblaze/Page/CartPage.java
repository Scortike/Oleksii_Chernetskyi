package demoblaze.Page;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class CartPage extends BaseSeleniumPage
{
    private By placeOrderButtonElement = By.xpath("//button[@class = 'btn btn-success']");
    private By placeOrderForm = By.xpath("//div[@id = 'orderModal']");
    private By inputNameElement = By.xpath("//input[@id = 'name']");
    private By inputCountryElement = By.xpath("//input[@id = 'country']");
    private By inputCityElement = By.xpath("//input[@id = 'city']");
    private By inputCardElement = By.xpath("//input[@id = 'card']");
    private By inputMonthElement = By.xpath("//input[@id = 'month']");
    private By inputYearElement = By.xpath("//input[@id = 'year']");
    private By purchaseOrderButton = By.xpath("//button[@onclick= 'purchaseOrder()']");
    private By totalPrice = By.xpath("//h3[@class='panel-title']");

    public CartPage()
    {
        PageFactory.initElements(driver, this);
    }

//    public CartPage placeOrder(String nameValue, String countryValue, String cityValue, String creditCardValue, String monthValue, String yearValue) throws InterruptedException {
//        placeOrderButtonElement.click();
//        inputNameElement.sendKeys(nameValue);
//        inputCountryElement.sendKeys(countryValue);
//        inputCityElement.sendKeys(cityValue);
//        inputCardElement.sendKeys(creditCardValue);
//        inputMonthElement.sendKeys(monthValue);
//        inputYearElement.sendKeys(yearValue);
//        purchaseOrderButton.click();
//        Thread.sleep(5000);
//        return this;
//    }

    public CartPage clickPlaceOrder()
    {
        waitVisibility(totalPrice);
        waitVisibility(placeOrderButtonElement);
        driver.findElement(placeOrderButtonElement).click();
        return this;
    }

    public boolean isPlaceOrderShows()
    {
        waitVisibility(placeOrderForm);
        return driver.findElement(placeOrderForm).isDisplayed();
    }
    public CartPage fillNameInput(String name)
    {
        waitVisibility(inputNameElement);
        driver.findElement(inputNameElement).sendKeys(name);
        return this;
    }

    public CartPage fillMonthInput(String month)
    {
        waitVisibility(inputMonthElement);
        driver.findElement(inputMonthElement).sendKeys(month);
        return this;
    }

    public CartPage fillCountryInput(String country)
    {
        waitVisibility(inputCountryElement);
        driver.findElement(inputCountryElement).sendKeys(country);
        return this;
    }

    public CartPage fillCreditCardInput(String creditCard)
    {
        waitVisibility(inputCardElement);
        driver.findElement(inputCardElement).sendKeys(creditCard);
        return this;
    }

    public CartPage fillCityInput(String city)
    {
        waitVisibility(inputCityElement);
        driver.findElement(inputNameElement).sendKeys(city);
        return this;
    }

    public CartPage fillYearInput(String year)
    {
        waitVisibility(inputYearElement);
        driver.findElement(inputYearElement).sendKeys(year);
        return this;
    }

    public CartPage clickPurchaseOrder()
    {
        waitVisibility(purchaseOrderButton);
        driver.findElement(purchaseOrderButton).click();
        return this;
    }
}
