package com.saucedemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void launchApplicationTest(){
        WebDriver driver = getDriver();
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void invalidLoginWithBlankUserNameAndPasswordTest(){
        WebDriver driver = getDriver();
        String expectedErrorMessage = "Epic sadface: Username is required";
        driver.findElement(By.id("login-button")).click();
        String actualErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void invalidLoginWithBlankPasswordTest(){
        WebDriver driver = getDriver();
        String expectedErrorMessage = "Epic sadface: Password is required";
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        String actualErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void invalidLoginWithWrongUserNameAndPasswordTest(){
        WebDriver driver = getDriver();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        String actualErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
}
