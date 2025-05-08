package elements;

import driver.JSUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LightningDropDown extends BaseElement {
    private static final String DROPDOWN_LOCATOR = "//label[text() = '%s']/ancestor::lightning-combobox//button";
    private static final String DROPDOWN_VALUE = "//lightning-base-combobox-item//span[text()='%s']";

    public LightningDropDown(WebDriver driver, String title) {
        super(driver, title);
    }
    @Step("Click Lightning Drop-Down using JavaScript")
    public void select(String text) {
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, title))));
        JSUtils.clickUsingJavaScript(driver, driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, text))));
    }
}
