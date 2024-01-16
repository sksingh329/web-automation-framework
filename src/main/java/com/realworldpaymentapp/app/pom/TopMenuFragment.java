package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuFragment extends BasePage {
    private WebDriver driver;
    private final By menuNewTransactionLink = By.xpath("//a[@href='/transaction/new']");

    public TopMenuFragment(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public TransactionPage clickMenuNewTransactionLink(){
        webElementActionUtils.clickElement(menuNewTransactionLink,10);
        return new TransactionPage(driver);
    }
}
