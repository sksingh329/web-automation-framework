package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage extends BasePage {
    private WebDriver driver;

    private WebElementActionUtils webElementActionUtils;

    private final By thankYouMessageLabel = By.xpath("//h2[@class='complete-header']");

    public ThankYouPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        webElementActionUtils = new WebElementActionUtils(driver);
    }

    public String getThankYouMessageLabel(){
        return webElementActionUtils.getLabelText(thankYouMessageLabel,0);
    }
}
