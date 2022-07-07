package demoblaze.Page;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import readProperties.ConfigProvider;

public class MainPage extends BaseSeleniumPage
{
    private By loginPushElement = By.xpath("//a[@id='login2']");
    private By laptopsButtonElement = By.xpath("//a[text() = 'Laptops']");
    private By dellLinkElement = By.xpath("//a[text() = 'Dell i7 8gb']");
    private By usernameInputElement = By.xpath("//input[@Id='loginusername']");
    private By passwordInputElement =  By.xpath("//input[@Id='loginpassword']");
    private By loginButtonElement = By.xpath("//button[@onclick='logIn()']");

    public MainPage()
    {
        driver.get(ConfigProvider.URL);
    }

    public MainPage login(String username, String password) {
        this.clickLogInButtonOnPage()
                .fillUsername(username)
                .fillPassword(password)
                .clickLogInButton()
                .isLoggedIn();
        return this;
    }

    public MainPage clickLogInButtonOnPage()
    {
        waitVisibility(loginPushElement);
        driver.findElement(loginPushElement).click();
        return this;
    }

    public MainPage fillUsername(String username)
    {
        waitVisibility(usernameInputElement);
        driver.findElement(usernameInputElement).sendKeys(username);
        return this;
    }

    public MainPage fillPassword(String password)
    {
        waitVisibility(passwordInputElement);
        driver.findElement(passwordInputElement).sendKeys(password);
        return this;
    }

    public MainPage clickLogInButton()
    {
        waitVisibility(loginButtonElement);
        driver.findElement(loginButtonElement).click();
        return this;
    }

    public MainPage clickLaptopsCategory()
    {
        waitVisibility(laptopsButtonElement);
        driver.findElement(laptopsButtonElement).click();
        return this;
    }

    public ProductPage clickDellItem()
    {
        waitVisibility(dellLinkElement);
        driver.findElement(dellLinkElement).click();
        return new ProductPage();
    }

    public boolean isLoggedIn() {
        this.waitVisibility(By.id("nameofuser"));
        return this.driver.findElement(By.id("nameofuser")).isDisplayed();
    }
}
