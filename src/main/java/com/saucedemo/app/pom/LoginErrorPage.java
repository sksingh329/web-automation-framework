package com.saucedemo.app.pom;

import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginErrorPage {
    private final WebElementActionUtils webElementActionUtils;
    private final By loginErrorLabel = By.xpath("//h3[@data-test='error']");

    public LoginErrorPage(WebDriver driver){
        webElementActionUtils = new WebElementActionUtils(driver);
    }

    public String getErrorMessage(){
        return webElementActionUtils.getLabelText(loginErrorLabel,0);
    }
}
