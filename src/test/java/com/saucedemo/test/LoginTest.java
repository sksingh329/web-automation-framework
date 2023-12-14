package com.saucedemo.test;

import com.saucedemo.app.pom.HomePage;
import com.saucedemo.app.pom.LoginErrorPage;
import com.saucedemo.test.base.BaseLoginTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseLoginTest {

    @Test
    public void invalidLoginWithBlankUserNameAndPasswordTest(){
        String expectedErrorMessage = "Epic sadface: Username is required";
        LoginErrorPage invalidLoginPage = loginPage.invalidLogin("","");
        String actualErrorMessage = invalidLoginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void invalidLoginWithBlankPasswordTest(){
        String expectedErrorMessage = "Epic sadface: Password is required";
        LoginErrorPage invalidLoginPage = loginPage.invalidLogin("test","");
        String actualErrorMessage = invalidLoginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void invalidLoginWithWrongUserNameAndPasswordTest(){
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        LoginErrorPage invalidLoginPage = loginPage.invalidLogin("test","test");
        String actualErrorMessage = invalidLoginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void validLoginTest(){
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        HomePage inventoryPage = loginPage.validLogin("standard_user","secret_sauce");
        Assert.assertEquals(inventoryPage.getPageUrl(),expectedUrl);
    }
}
