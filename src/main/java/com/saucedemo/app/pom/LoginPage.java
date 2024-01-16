package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final WebDriver driver;

    private static final By usernameInput = By.id("user-name");
    private static final By passwordInput = By.id("password");
    private static final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
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
