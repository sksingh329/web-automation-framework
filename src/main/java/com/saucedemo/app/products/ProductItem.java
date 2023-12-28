package com.saucedemo.app.products;

public class ProductItem {
    private final String productName;
    private final String productDetail;
    private final String productPrice;

    public ProductItem(String productName, String productDetail, String productPrice){
        this.productName = productName;
        this.productDetail = productDetail;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
