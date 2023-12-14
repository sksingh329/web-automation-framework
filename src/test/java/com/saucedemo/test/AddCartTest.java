package com.saucedemo.test;

import com.saucedemo.app.flow.ProductFlow;
import com.saucedemo.app.flow.UserLoginLogoutFlow;
import com.saucedemo.app.pom.HomePage;
import com.saucedemo.app.pom.LoginPage;
import com.saucedemo.app.pom.ProductDetailsPage;
import com.saucedemo.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    Validate cart is empty
     */
    @Test
    public void orderToCheckoutWithOneProductTest(){

    }
}
