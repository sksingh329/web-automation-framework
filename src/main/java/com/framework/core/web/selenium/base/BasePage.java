package com.framework.core.web.selenium.base;

import com.framework.core.web.selenium.alert.HandleAlert;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver driver;
    protected WebElementActionUtils webElementActionUtils;
    protected HandleAlert handleAlert;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.webElementActionUtils = new WebElementActionUtils(driver);
        this.handleAlert = new HandleAlert(driver);
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}
