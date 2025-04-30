package elements;

import driver.JSUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Button extends BaseElement {
    private static final String BUTTON_LOCATOR = "//button[@title='%s']|//div[@title='%s']|//div/a[@title='%s']|//button[text()='%s']";
    private static final String MODAL_LOCATOR = "//div[contains(@class,'modal-container')]";
    private static final String BUTTON_LOCATOR_IN_MODAL_LOCATOR = "//button[@title='%s']|//button[text()='%s']";
    public Button(WebDriver driver, String title) {
        super(driver, title);
    }

    public void click() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(MODAL_LOCATOR)).size() > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BUTTON_LOCATOR_IN_MODAL_LOCATOR, title, title))));
            driver.findElement(By.xpath(String.format(BUTTON_LOCATOR_IN_MODAL_LOCATOR, title, title))).click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BUTTON_LOCATOR, title, title, title, title))));
            driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, title, title, title, title))).click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Click using JavaScript")
    public void clickUsingJavaScript() {
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, title, title, title, title))));
    }
}
