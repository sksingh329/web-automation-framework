package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.saucedemo.app.pom.MenuFragment;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    private TopMenuFragment topMenuFragment;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        topMenuFragment = new TopMenuFragment(driver);
    }
    public TopMenuFragment getTopMenuFragment(){
        return topMenuFragment;
    }
}
