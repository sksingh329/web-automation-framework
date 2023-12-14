package com.framework.core.web.selenium.element;

import com.framework.core.web.selenium.element.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WebElementActionUtils extends WebElementUtils {

    public WebElementActionUtils(WebDriver driver){
        super(driver);
    }
    public void enterText(By locator, String text,int timeoutInSeconds){
            findElement(locator,timeoutInSeconds).sendKeys(text);
    }
    public void clickElement(By locator,int timeoutInSeconds){
        findElement(locator,timeoutInSeconds).click();
    }
    public String getLabelText(By locator,int timeoutInSeconds){
        return findElement(locator,timeoutInSeconds).getText();
    }
    public String getElementAttributeValue(By locator, String attributeName,int timeoutInSeconds){
        return findElement(locator,timeoutInSeconds).getAttribute(attributeName);
    }
}
