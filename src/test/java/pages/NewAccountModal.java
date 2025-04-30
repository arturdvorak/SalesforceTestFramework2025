package pages;

import elements.*;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountModal extends BasePage {
    private static final String ENTITY_NAME_TITLE_LOCATOR = "//lightning-formatted-text[text()='%s']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public NewAccountModal fillOutNewContactModal(Account account) {
        waitForPageLoaded();
        new LightningInput(driver, "Account Name").fillInput(account.getAccountName());
        new LightningLookUp(driver, "Parent Account").select(account.getParentAccount());
        new LightningInput(driver, "Account Number").fillInput(Integer.toString(account.getAccountNumber()));
        new LightningInput(driver, "Account Site").fillInput(account.getAccountSite());
        new LightningDropDown(driver, "Type").select(account.getType());
        new LightningDropDown(driver, "Industry").select(account.getIndustry());
        new LightningInput(driver, "Annual Revenue").fillInput(Integer.toString(account.getAnnualRevenue()));
        new LightningDropDown(driver, "Rating").select(account.getRating());
        new LightningInput(driver, "Phone").fillInput(account.getPhone());
        new LightningInput(driver, "Fax").fillInput(account.getFax());
        new LightningInput(driver, "Website").fillInput(account.getWebsite());
        new LightningInput(driver, "Ticker Symbol").fillInput(account.getTickerSymbol());
        new LightningDropDown(driver, "Ownership").select(account.getOwnership());
        new LightningInput(driver, "Employees").fillInput(Integer.toString(account.getEmployees()));
        new LightningInput(driver, "SIC Code").fillInput(Integer.toString(account.getSicCode()));
        new TextArea(driver, "Billing Street").fillInput(account.getBillingStreet());
        new LightningInput(driver, "Billing City").fillInput(account.getBillingCity());
        new LightningInput(driver, "Billing State/Province").fillInput(account.getBillingState());
        new LightningInput(driver, "Billing Zip/Postal Code").fillInput(account.getBillingZip());
        new LightningInput(driver, "Billing Country").fillInput(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").fillInput(account.getMailingStreet());
        new LightningInput(driver, "Shipping City").fillInput(account.getMailingCity());
        new LightningInput(driver, "Shipping State/Province").fillInput(account.getMailingState());
        new LightningInput(driver, "Shipping Zip/Postal Code").fillInput(account.getMailingZip());
        new LightningInput(driver, "Shipping Country").fillInput(account.getMailingCountry());
        new LightningDropDown(driver, "Customer Priority").select(account.getCustomerPriority());
        new LightningInput(driver, "Number of Locations").fillInput(Integer.toString(account.getNumberOfLocations()));
        new LightningDropDown(driver, "Active").select(account.getActive());
        new LightningDropDown(driver, "SLA").select(account.getSla());
        new LightningDropDown(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        new TextArea(driver, "Description").fillInput(account.getDescription());
        return this;
    }

    public AccountListPage saveAccount(Account account) {
        new Button(driver,"Save").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(ENTITY_NAME_TITLE_LOCATOR, account.getAccountName()))));
        return new AccountListPage(driver);
    }
}
