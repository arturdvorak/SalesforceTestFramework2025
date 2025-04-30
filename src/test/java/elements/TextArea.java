package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea extends BaseElement {
    private static final String TEXTAREA_LOCATOR = "//*[text() = '%s']/../..//textarea";

    public TextArea(WebDriver driver, String title) {
        super(driver, title);
    }

    public void fillInput(String text) {
        WebElement element = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, title)));
        element.clear();
        element.sendKeys(text);
    }
}
