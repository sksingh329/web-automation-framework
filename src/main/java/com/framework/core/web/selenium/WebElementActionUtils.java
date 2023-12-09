package com.framework.core.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementActionUtils extends WebElementUtils{
    private final WebDriver driver;

    public WebElementActionUtils(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public void enterText(By locator, String text){
        findElement(locator).sendKeys(text);
    }
    public void clickElement(By locator){
        findElement(locator).click();
    }
    public String getLabelText(By locator){
        return findElement(locator).getText();
    }
}
