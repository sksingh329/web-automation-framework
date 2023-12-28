package com.framework.core.web.selenium.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {

    public enum SelectBy{
        value,text
    }
    public HandleDropdown(){

    }

    public void selectBy(WebElement elem,SelectBy selectBy, String value){
        Select select = new Select(elem);
        switch (selectBy){
            case value:
                select.selectByValue(value);
                break;
            case text:
                select.selectByVisibleText(value);
                break;
        }

    }
}
