package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.AccountSteps;
import steps.LoginSteps;
import utils.PropertyReader;

public class BaseTest {
    public static String browserType;
    public static String loginUrl;
    public static String baseUrl;
    String username;
    String password;
    protected WebDriver driver; // why not private?
    LoginSteps loginSteps;
    // ContactSteps contactSteps;
    AccountSteps accountSteps;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp() {
        loginUrl = PropertyReader.getFromEnvOrFile("LOGIN_URL", "login.url");
        username = PropertyReader.getFromEnvOrFile("USERNAME_SF", "username");
        password = PropertyReader.getFromEnvOrFile("PASSWORD_SF", "password");
        browserType = PropertyReader.getFromEnvOrFile("BROWSER_TYPE", "browser.type");
        baseUrl = PropertyReader.getFromEnvOrFile("BASE_URL_LIGHT", "base.url.light");
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf("GC"));
        loginSteps = new LoginSteps(driver);
        //contactSteps = new ContactSteps(driver);
        accountSteps = new AccountSteps(driver);
    }

    @AfterClass(description = "Closing browser", alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
