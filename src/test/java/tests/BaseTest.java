package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp() {
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf("GC"));
    }

    @AfterClass(description = "Closing browser", alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
