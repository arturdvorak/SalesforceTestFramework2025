package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void firstTest() {
        loginSteps
                .open()
                .login(username, password);
    }
}
