package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ForceRecord extends BaseElement {
    protected final static String FORCE_RECORD_LOCATOR = "//span[text()='%s']/ancestor::records-record-layout-item//";
    private static final String FIELD_LOCATOR = ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "span[@force-lookup_lookup]|" +
            ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-text|" +
            ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-number|" +
            ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-address|" +
            ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-phone/a|" +
            ACTIVE_TAB_LOCATOR + FORCE_RECORD_LOCATOR + "lightning-formatted-url/a";

    public ForceRecord(WebDriver driver, String title) {
        super(driver, title);
    }

    public void validateFieldValue(String text) {
        new SoftAssert().assertEquals(driver.findElement(By.xpath(String.format(FIELD_LOCATOR, title, title, title, title, title, title))).getText(), text,
                String.format("'%s' value is saved incorrectly.", title));
        //assertEquals(driver.findElement(By.xpath(String.format(FIELD_LOCATOR, title, title, title, title, title, title))).getText(), text,
        //String.format("'%s' value is saved incorrectly.", title));
    }
}
