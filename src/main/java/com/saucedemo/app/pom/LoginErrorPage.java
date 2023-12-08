package com.saucedemo.app.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginErrorPage {
    private final WebDriver driver;
    private final By loginErrorLabel = By.xpath("//h3[@data-test='error']");

    public LoginErrorPage(WebDriver driver){
        this.driver = driver;
    }

    public String getErrorMessage(){
        return driver.findElement(loginErrorLabel).getText();
    }
}
