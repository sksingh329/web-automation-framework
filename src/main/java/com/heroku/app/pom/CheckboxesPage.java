package com.heroku.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage extends BasePage {
    private final WebDriver driver;

    private final By checkboxInput = By.xpath("//form[@id='checkboxes']/input");
    private final By firstCheckboxInput = By.xpath("(//form[@id='checkboxes']/input)[1]");
    private final By secondCheckboxInput = By.xpath("(//form[@id='checkboxes']/input)[2]");

    public CheckboxesPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickFirstCheckbox(){
        webElementActionUtils.clickElement(firstCheckboxInput,10);
    }
    public void clickSecondCheckbox(){
        webElementActionUtils.clickElement(secondCheckboxInput,10);
    }

    public int getCheckboxCount(){
        return webElementActionUtils.findElements(checkboxInput,10).size();
    }
    private boolean isCheckedAttributePresent(By locator){
        String checked = webElementActionUtils.getElementAttributeValue(locator,"checked",10);
        if(checked != null) return true;
        else return false;
    }
    public boolean isCheckboxSelected(String checkbox){
        boolean isCheckBoxSelectedFlag = false;
        switch (checkbox){
            case "first":
                isCheckBoxSelectedFlag = isCheckedAttributePresent(firstCheckboxInput);
                break;
            case "second":
                isCheckBoxSelectedFlag = isCheckedAttributePresent(secondCheckboxInput);
                break;
        }
        return isCheckBoxSelectedFlag;
    }
}
