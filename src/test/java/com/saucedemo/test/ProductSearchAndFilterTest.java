package com.saucedemo.test;

import com.saucedemo.app.products.ProductItem;
import com.saucedemo.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSearchAndFilterTest extends BaseTest {
    /*
    On home page, check that product exists can also have test if product should not exist
     */
    @Test
    public void checkProductExistTest(){
        String[] products = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Onesie"};


        List<ProductItem> productItemsList = homePage.getProducts();
        for(ProductItem productItem:productItemsList){
            System.out.println("Name : " + productItem.getProductName() + ", Price : " + productItem.getProductPrice());
        }
        // Extracting product names from the list
        List<String> actualProductNames = productItemsList.stream()
                .map(ProductItem::getProductName)
                .collect(Collectors.toList());

        for(String product: products){
            Assert.assertTrue(actualProductNames.contains(product));
        }
    }
    @Test
    public void checkProductNotExistTest(){
        String[] products = {"Sauce Labs Backpack New","Sauce Labs Bike Light Updated","Random Product Name"};


        List<ProductItem> productItemsList = homePage.getProducts();

        // Extracting product names from the list
        List<String> actualProductNames = productItemsList.stream()
                .map(ProductItem::getProductName)
                .collect(Collectors.toList());

        for(String product: products){
            Assert.assertFalse(actualProductNames.contains(product));
        }
    }
    @Test
    public void priceFilterLowToHigh(){
        List<ProductItem> productItemsList = homePage.getProducts();

        // Extracting product price from the list
        List<String> productPriceList = productItemsList.stream()
                .map(ProductItem::getProductPrice)
                .collect(Collectors.toList());

        List<Double> productPriceInDecimalList = productPriceList.stream()
                .map(ProductSearchAndFilterTest::extractDecimalValue).sorted().collect(Collectors.toList());

        homePage.sortProduct("Price (low to high)");

        productItemsList = homePage.getProducts();

        List<String> productPriceAfterSortList = productItemsList.stream()
                .map(ProductItem::getProductPrice)
                .collect(Collectors.toList());

        List<Double> productPriceInDecimalAfterSortList = productPriceAfterSortList.stream()
                .map(ProductSearchAndFilterTest::extractDecimalValue)
                .collect(Collectors.toList());

        Assert.assertEquals(productPriceInDecimalAfterSortList, productPriceInDecimalList);

    }
    private static double extractDecimalValue(String value) {
        // Remove non-numeric characters and parse to double
        String numericValue = value.replaceAll("[^\\d.]", "");
        return Double.parseDouble(numericValue);
    }
}
