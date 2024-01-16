package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import com.saucedemo.app.products.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final WebDriver driver;
    private final MenuFragment menu;

    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private final By removeButton = By.xpath("//button[text()='Remove']");
    private final By backToProductsButton = By.id("back-to-products");
    private final By productTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By productDetails = By.xpath("//div[@class='inventory_details_desc large_size']");
    private final By productPrice = By.xpath("//div[@class='inventory_details_price']");

    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.menu = new MenuFragment(driver);
    }

    public void clickAddToCartButton(){
        webElementActionUtils.clickElement(addToCartButton,0);
    }
    public void clickRemoveButton(){
        webElementActionUtils.clickElement(removeButton,0);
    }
    public HomePage clickBackToProductsButton(){
        webElementActionUtils.clickElement(backToProductsButton,0);
        return new HomePage(driver);
    }
    public String getProductTitle(){
        return webElementActionUtils.getLabelText(productTitle,0);
    }
    public String getProductDetails(){
        return webElementActionUtils.getLabelText(productDetails,0);
    }
    public String getProductPrice(){
        return webElementActionUtils.getLabelText(productPrice,0);
    }

    public ProductItem getProductItem(){
        return new ProductItem(getProductTitle(),getProductDetails(),getProductPrice());
    }
}
