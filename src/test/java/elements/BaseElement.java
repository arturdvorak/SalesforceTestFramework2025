package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseElement {
    protected WebDriver driver;
    protected String title;
    protected WebDriverWait wait;
    protected final static String ACTIVE_TAB_LOCATOR = "//div[contains(@class,'active')]";

    public BaseElement(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
