package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BaseSeleniumPage
{
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected BaseSeleniumPage()
    {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected static  void setDriver(WebDriver webDriver)
    {
        driver = webDriver;
    }

    protected void waitVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public  static void exit()
    {
        driver.close();
        driver.quit();
    }

    public String getPageURL()
    {
        return driver.getCurrentUrl();
    }

}
