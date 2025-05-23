package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    AccountFactory accountFactory = new AccountFactory();

    @Test
    public void firstTest() {
        loginSteps
                .open()
                .login(username, password);
        Account account = accountFactory.getAccount("Test1");
        Account accountUpdated = accountFactory.getAccount("Test2");
        accountSteps
                .createNewAccount(account)
                .validationOfAccount(account)
                .updateAccount(account, accountUpdated)
                .validationOfAccount(accountUpdated)
                .removeAccount(accountUpdated);
    }
}
