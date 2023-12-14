package com.saucedemo.app.flow;

import com.saucedemo.app.pom.HomePage;
import com.saucedemo.app.pom.ProductDetailsPage;

public class ProductFlow {
    public static void addProductToCart(HomePage homePage,String productName){
        ProductDetailsPage productDetailsPage = homePage.clickProduct(productName);
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.clickBackToProductsButton();
    }
}
