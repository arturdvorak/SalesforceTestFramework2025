package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;
import pages.AccountViewPage;
import pages.NewAccountModal;

@Log4j2
public class AccountSteps {
    NewAccountModal newAccountModal;
    AccountListPage accountListPage;
    AccountViewPage accountViewPage;

    public AccountSteps(WebDriver driver) {
        newAccountModal = new NewAccountModal(driver);
        accountListPage = new AccountListPage(driver);
        accountViewPage = new AccountViewPage(driver);
    }

    @Step("New account creation")
    public AccountSteps createNewAccount(Account account) {
        log.info("New account creation");
        accountListPage
                .openPage()
                .openNewAccountModal();
        newAccountModal
                .fillOutNewContactModal(account)
                .saveAccount(account);
        return this;
    }

    @Step("Account validation")
    public AccountSteps validationOfAccount(Account account) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .validateAccountData(account);
        return this;
    }

    @Step("Account updating")
    public AccountSteps updateAccount(Account account, Account account_updated) {
        accountListPage
                .openPage()
                .openAccount(account);
        accountViewPage
                .updateOpenAccount(account_updated);
        return this;
    }

    @Step("Account removal")
    public AccountSteps removeAccount(Account account_updated) {
        accountListPage
                .openPage();
        accountViewPage
                .deleteAccountByName(account_updated);
        return this;
    }
}
