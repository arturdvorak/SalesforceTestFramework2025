package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class LoginPage extends BasePage {
    private static final By USERNAME_CSS = By.id("username");
    private static final By INPUT_PASSWORD = By.id("password");
    private static final By INPUT_LOGIN = By.id("Login");
    private static final String USER_IMAGE_LOCATOR = "//img[contains(@alt,'User')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public void openPage () {
        driver.get(BaseTest.loginUrl);
    }

    @Step("Log in with {userName} and {passwordKeys}")
    public void login(String userName, String passwordKeys) {
        driver.findElement(USERNAME_CSS).sendKeys(userName);
        driver.findElement(INPUT_PASSWORD).sendKeys(passwordKeys);
        driver.findElement(INPUT_LOGIN).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(USER_IMAGE_LOCATOR)));
    }
}
