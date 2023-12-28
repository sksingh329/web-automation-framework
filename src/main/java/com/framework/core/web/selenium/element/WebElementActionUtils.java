package com.framework.core.web.selenium.element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebElementActionUtils extends WebElementUtils {

    private HandleDropdown handleDropdown;

    public WebElementActionUtils(WebDriver driver){
        super(driver);
        handleDropdown = new HandleDropdown();
    }

    public HandleDropdown getHandleDropdown() {
        return handleDropdown;
    }

    public void enterText(By locator, String text, int timeoutInSeconds){
            findElement(locator,timeoutInSeconds).sendKeys(text);
    }
    public void clickElement(By locator,int timeoutInSeconds){
        findElement(locator,timeoutInSeconds).click();
    }
    public String getLabelText(By locator,int timeoutInSeconds){
        WebElement elem = findElement(locator,timeoutInSeconds);
        return getLabelText(elem);
    }
    public String getLabelText(WebElement elem){
        return elem.getText();
    }
    public String getElementAttributeValue(By locator, String attributeName,int timeoutInSeconds){
        return findElement(locator,timeoutInSeconds).getAttribute(attributeName);
    }
}
