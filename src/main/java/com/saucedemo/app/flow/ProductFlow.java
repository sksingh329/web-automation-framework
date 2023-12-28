package com.saucedemo.app.flow;

import com.saucedemo.app.pom.HomePage;
import com.saucedemo.app.pom.ProductDetailsPage;
import com.saucedemo.app.products.ProductItem;

public class ProductFlow {
    public static ProductItem addProductToCart(HomePage homePage,String productName){
        ProductDetailsPage productDetailsPage = homePage.clickProduct(productName);
        productDetailsPage.clickAddToCartButton();
        ProductItem productItem = productDetailsPage.getProductItem();
        productDetailsPage.clickBackToProductsButton();
        return productItem;
    }
    public static ProductItem removeProductFromCart(HomePage homePage,String productName){
        ProductDetailsPage productDetailsPage = homePage.clickProduct(productName);
        productDetailsPage.clickRemoveButton();
        ProductItem productItem = productDetailsPage.getProductItem();
        productDetailsPage.clickBackToProductsButton();
        return productItem;
    }
}
