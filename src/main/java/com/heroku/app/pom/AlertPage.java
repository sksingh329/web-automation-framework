package com.heroku.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    private final WebDriver driver;

    private final By clickForJsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private final By resultLabel = By.id("result");

    public AlertPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public void setClickForJsAlertButton(){
        webElementActionUtils.clickElement(clickForJsAlertButton,10);
    }
    public void acceptAlert(){
        if(handleAlert.isAlertPresent()){
            handleAlert.accept();
        }
    }
    public String getResult(){
        return webElementActionUtils.getLabelText(resultLabel,0);
    }
}
