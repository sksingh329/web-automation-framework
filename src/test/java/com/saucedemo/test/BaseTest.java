package com.saucedemo.test;

import com.framework.core.web.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected String appUrl = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        WebDriver driver = WebDriverFactory.getInstance().getDriver();
        driver.get(appUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        WebDriverFactory.getInstance().releaseDriver();
    }
    protected WebDriver getDriver(){
        return WebDriverFactory.getInstance().getDriver();
    }
}
