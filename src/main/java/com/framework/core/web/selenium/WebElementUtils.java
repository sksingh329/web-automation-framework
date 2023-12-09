package com.framework.core.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtils {
        private final WebDriver driver;

        public WebElementUtils(WebDriver driver){
            this.driver = driver;
        }

        public WebElement findElement(By locator){
            return driver.findElement(locator);
        }
}
