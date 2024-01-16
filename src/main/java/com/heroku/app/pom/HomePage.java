package com.heroku.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final WebDriver driver;

    private final By checkboxesLink = By.linkText("Checkboxes");
    private final By alertLink = By.linkText("JavaScript Alerts");

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public CheckboxesPage clickCheckboxesLink(){
        webElementActionUtils.clickElement(checkboxesLink,10);
        return new CheckboxesPage(driver);
    }

    public AlertPage clickAlertLink(){
        webElementActionUtils.clickElement(alertLink,10);
        return new AlertPage(driver);
    }
}
