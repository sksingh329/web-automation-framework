package com.saucedemo.test;

import com.saucedemo.app.flow.ProductFlow;
import com.saucedemo.app.flow.UserLoginLogoutFlow;
import com.saucedemo.app.pom.*;
import com.saucedemo.app.products.ProductItem;
import com.saucedemo.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class AddCartTest extends BaseTest {
    /*
    Add item in cart then Log out
    Login again and check that item is there in cart
     */
    @Test
    public void cartItemRemainsSameAfterLogoutTest(){
        homePage.getMenu().clickResetAppStateLink();
        ProductFlow.addProductToCart(homePage,"Sauce Labs Backpack");

        Assert.assertEquals(homePage.getMenu().getCartItemCount(),"1");

        LoginPage loginPage = homePage.getMenu().clickLogout();

        homePage = UserLoginLogoutFlow.login(loginPage,"standard_user","secret_sauce");
        Assert.assertEquals(homePage.getMenu().getCartItemCount(),"1");
    }
    /*
    Add one product to cart and checkout
    Fill checkout details
    Validate item price and name on Checkout:Overview
    Validate delivery message on checkout:complete
     */
    @Test
    public void orderToCheckoutWithOneProductTest(){
        String productName = "Sauce Labs Bike Light";
        homePage.getMenu().clickResetAppStateLink();
        ProductItem productItem = ProductFlow.addProductToCart(homePage,productName);
        String productPrice = productItem.getProductPrice();
        Assert.assertEquals(productItem.getProductName(),productName);
        CartPage cartPage = homePage.getMenu().clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.fillCheckoutForm("subodh","singh","1111");
        String subTotalPrice = checkoutOverviewPage.getSubTotalPriceLabel();
        ThankYouPage thankYouPage = checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(subTotalPrice,"Item total: "+productPrice);
        Assert.assertEquals(thankYouPage.getThankYouMessageLabel(),"Thank you for your order!");
    }
    @Test
    public void subTotalIsCorrectFor2ProductTest(){
        String productName1 = "Sauce Labs Backpack";
        String productName2 = "Sauce Labs Bike Light";
        homePage.getMenu().clickResetAppStateLink();
        ProductItem productItem;

        productItem = ProductFlow.addProductToCart(homePage,productName1);
        String productPrice1 = productItem.getProductPrice();
        productItem = ProductFlow.addProductToCart(homePage,productName2);
        String productPrice2 = productItem.getProductPrice();

        BigDecimal decimalValue1 = new BigDecimal(productPrice1.replaceAll("\\$", ""));
        BigDecimal decimalValue2 = new BigDecimal(productPrice2.replaceAll("\\$", ""));

        BigDecimal decimalSum = decimalValue1.add(decimalValue2);

        String subTotal = "$" + decimalSum;


        CartPage cartPage = homePage.getMenu().clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.fillCheckoutForm("subodh","singh","1111");
        String subTotalPrice = checkoutOverviewPage.getSubTotalPriceLabel();
        Assert.assertEquals(subTotalPrice,"Item total: "+subTotal);
    }
    @Test
    public void productNameIsCorrectOnOrderOverviewForMultipleItemInCart(){
        String productName1 = "Sauce Labs Backpack";
        String productName2 = "Sauce Labs Bike Light";
        homePage.getMenu().clickResetAppStateLink();

        ProductFlow.addProductToCart(homePage,productName1);
        ProductFlow.addProductToCart(homePage,productName2);

        CartPage cartPage = homePage.getMenu().clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.fillCheckoutForm("subodh","singh","1111");
        List<ProductItem> productItems = checkoutOverviewPage.getCartItems();

        // Extracting product names from the list
        List<String> actualProductNames = productItems.stream()
                .map(ProductItem::getProductName)
                .collect(Collectors.toList());

        // Asserting that both product names are present in the actual list
        Assert.assertTrue(actualProductNames.contains(productName1));
        Assert.assertTrue(actualProductNames.contains(productName2));
    }
    /*
    Add 2 products in cart
    Click on Reset App State
    Validate cart is empty
     */
    @Test
    public void resetAppStateTest(){
        String productName1 = "Sauce Labs Backpack";
        String productName2 = "Sauce Labs Bike Light";
        homePage.getMenu().clickResetAppStateLink();

        ProductFlow.addProductToCart(homePage,productName1);
        ProductFlow.addProductToCart(homePage,productName2);

        Assert.assertEquals(homePage.getMenu().getCartItemCount(),"2");

        homePage.getMenu().clickResetAppStateLink();

        Assert.assertEquals(homePage.getMenu().getCartItemCount(),"0");
    }
    /*
    Add 2 products in cart
    Click on Remove button on 1 product
    Validate cart count is updated to 1
     */
    @Test
    public void cartIsUpdatedAfterRemoveTest(){
        String productName1 = "Sauce Labs Backpack";
        String productName2 = "Sauce Labs Bike Light";
        homePage.getMenu().clickResetAppStateLink();

        ProductFlow.addProductToCart(homePage,productName1);
        ProductFlow.addProductToCart(homePage,productName2);

        Assert.assertEquals(homePage.getMenu().getCartItemCount(),"2");

        ProductFlow.removeProductFromCart(homePage,productName2);

        Assert.assertEquals(homePage.getMenu().getCartItemCount(),"1");
    }

}
