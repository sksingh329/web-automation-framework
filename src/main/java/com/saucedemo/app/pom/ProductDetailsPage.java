package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final WebDriver driver;
    private WebElementActionUtils webElementActionUtils;
    private final MenuFragment menu;

    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private final By backToProductsButton = By.id("back-to-products");

    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.webElementActionUtils = new WebElementActionUtils(driver);
        this.menu = new MenuFragment(driver);
    }

    public void clickAddToCartButton(){
        webElementActionUtils.clickElement(addToCartButton,0);
    }
    public HomePage clickBackToProductsButton(){
        webElementActionUtils.clickElement(backToProductsButton,0);
        return new HomePage(driver);
    }
}
