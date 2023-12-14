package com.framework.core.web.selenium.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}
