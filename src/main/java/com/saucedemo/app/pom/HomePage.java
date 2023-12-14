package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final WebDriver driver;
    private WebElementActionUtils webElementActionUtils;
    private final MenuFragment menu;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.webElementActionUtils = new WebElementActionUtils(driver);
        this.menu = new MenuFragment(driver);
    }

    public MenuFragment getMenu(){
        return menu;
    }

    public ProductDetailsPage clickProduct(String productName){
        webElementActionUtils.clickElement(By.linkText(productName),0);
        return new ProductDetailsPage(driver);
    }

}
