package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private WebDriver driver;

    private WebElementActionUtils webElementActionUtils;

    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.webElementActionUtils = new WebElementActionUtils(driver);
    }

    public CheckoutPage clickCheckoutButton(){
        webElementActionUtils.clickElement(checkoutButton,0);
        return new CheckoutPage(driver);
    }

}
