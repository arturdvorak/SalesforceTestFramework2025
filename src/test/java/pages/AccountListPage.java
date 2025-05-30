package pages;

import elements.Button;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static tests.BaseTest.baseUrl;

public class AccountListPage extends BasePage {
    private final String URL_ACCOUNT_TAB = baseUrl + "o/Account/list";
    private static final By TITLE_ACCOUNT_IN_PANEL = By.xpath("//h1//records-entity-label[text()='Account']");
    private static final By TITLE_NEW_ACCOUNT_IN_MODAL = By.xpath("//h2[text()='New Account']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage openPage() {
        driver.get(URL_ACCOUNT_TAB);
        return this;
    }

    public NewAccountModal openNewAccountModal() {
        new Button(driver, "New").click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TITLE_NEW_ACCOUNT_IN_MODAL)));
        return new NewAccountModal(driver);
    }

    public String getAccountLink(Account account) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", account.getAccountName()))).getAttribute("href");
    }

    public AccountViewPage openAccount(Account account) {
        driver.get(getAccountLink(account));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_ACCOUNT_IN_PANEL));
        return new AccountViewPage(driver);
    }

}
