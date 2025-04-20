package driver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance(BrowserType browserType) {
        if (null == driver) {
            driver = createDriver(browserType);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver createDriver(BrowserType browserType) {
        WebDriverCreator creator;
        switch (browserType) {
            case FF:
                creator = new FirefoxDriverCreator();
                break;
            case GC:
                creator = new ChromeDriverCreator();
                break;
            default:
                creator = new ChromeDriverCreator();
        }
        driver = creator.factoryMethod();
        return driver;
    }
}
