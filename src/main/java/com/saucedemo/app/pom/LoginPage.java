package com.saucedemo.app.pom;

import com.framework.core.web.selenium.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final WebElementActionUtils webElementActionUtils;

    private static final By usernameInput = By.id("user-name");
    private static final By passwordInput = By.id("password");
    private static final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        webElementActionUtils = new WebElementActionUtils(driver);
    }

    private void doLogin(String username, String password){
        if(!username.equals("")){
            webElementActionUtils.enterText(usernameInput,username,0);
        }
        if(!password.equals("")){
            webElementActionUtils.enterText(passwordInput,password,0);
        }
        webElementActionUtils.clickElement(loginButton,0);
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
