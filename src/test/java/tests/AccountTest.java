package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void firstTest() {
        driver.get("https://www.google.com/");
    }
}
