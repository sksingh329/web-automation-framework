package com.framework.core.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementUtils {
        private final WebDriver driver;

        public WebElementUtils(WebDriver driver){
            this.driver = driver;
        }

        public WebElement findElement(By locator, int timeoutInSeconds) {
            if (timeoutInSeconds > 0) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } else {
                return driver.findElement(locator);
            }
        }
}
