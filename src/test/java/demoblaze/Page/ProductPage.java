package demoblaze.Page;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BaseSeleniumPage
{
    private By addButton = By.xpath("//a[@class = 'btn btn-success btn-lg']");
    private By cartButton = By.xpath("//a[text() = 'Cart']");
    private By productNameField = By.xpath("//h2[@class='name']");

    public ProductPage()
    {
    }

    public String getProductName() {
        waitVisibility(productNameField);
        return driver.findElement(productNameField).getText();
    }

    public CartPage addLaptop()
    {
        driver.findElement(addButton).click();
        driver.findElement(cartButton).click();
        return new CartPage();
    }

    public ProductPage addToCart()
    {
        waitVisibility(addButton);
        driver.findElement(addButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }

    public CartPage clickCart()
    {
        waitVisibility(cartButton);
        driver.findElement(cartButton).click();
        return new CartPage();
    }


}
