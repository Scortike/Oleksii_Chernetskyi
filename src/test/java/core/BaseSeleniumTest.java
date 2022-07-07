package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest
{
    protected WebDriver driver;

    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }

    public void tearDown()
    {
        driver.close();
        driver.quit();
    }
}
