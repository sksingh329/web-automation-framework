package com.framework.core.web.selenium.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        public List<WebElement> findElements(By locator, int timeoutInSeconds) {
            List<WebElement> webElementList = null;
            if (timeoutInSeconds > 0) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            }
            return driver.findElements(locator);
        }
}
