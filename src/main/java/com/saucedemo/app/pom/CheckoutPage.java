package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final WebDriver driver;

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private void submitCheckoutForm(String firstName, String lastName, String postalCode){
        webElementActionUtils.enterText(firstNameInput,firstName,0);
        webElementActionUtils.enterText(lastNameInput,lastName,0);
        webElementActionUtils.enterText(postalCodeInput,postalCode,0);
        webElementActionUtils.clickElement(continueButton,0);
    }

    public CheckoutOverviewPage fillCheckoutForm(String firstName, String lastName, String postalCode){
        submitCheckoutForm(firstName,lastName,postalCode);
        return new CheckoutOverviewPage(driver);
    }

}
