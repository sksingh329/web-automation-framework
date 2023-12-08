package com.saucedemo.app.pom;

import com.framework.core.web.selenium.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
