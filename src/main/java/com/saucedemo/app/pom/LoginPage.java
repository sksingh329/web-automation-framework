package com.saucedemo.app.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private static final By usernameInput = By.id("user-name");
    private static final By passwordInput = By.id("password");
    private static final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private void doLogin(String username, String password){
        if(!username.equals("")){
            driver.findElement(usernameInput).sendKeys(username);
        }
        if(!password.equals("")){
            driver.findElement(passwordInput).sendKeys(password);
        }

        driver.findElement(loginButton).click();
    }

    public LoginErrorPage invalidLogin(String username, String password){
        doLogin(username,password);
        return new LoginErrorPage(driver);
    }
    public HomePage validLogin(String userName, String password){
        doLogin(userName,password);
        return new HomePage(driver);
    }

}
