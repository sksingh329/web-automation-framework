package com.framework.core.web.selenium.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HandleAlert {
    private final WebDriver driver;

    public HandleAlert(WebDriver driver){
        this.driver = driver;
    }
    private Alert getAlert(){
        Alert alert = null;
        if(isAlertPresent()){
            alert = driver.switchTo().alert();
        }
        return alert;
    }

    //TODO - Implement timeout to check presence of alert if not found
    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException ex){
            return false;
        }
    }

    public void accept(){
        getAlert().accept();
    }
    public void dismiss(){
        getAlert().dismiss();
    }
    public String getText(){
        return getAlert().getText();
    }
    public void sendKeys(String keysToSend){
        getAlert().sendKeys(keysToSend);
    }
}
