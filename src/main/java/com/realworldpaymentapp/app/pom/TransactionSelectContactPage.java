package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TransactionSelectContactPage extends BasePage {
    private final WebDriver driver;
    private final By userSearchInput = By.id("user-list-search-input");
    private final By userSearchResultFirstContact = By.xpath("(//ul[@data-test='users-list']/li)[1]");

    public TransactionSelectContactPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public TransactionPaymentPage selectContact(String username){
        //TODO - Issue -> First contact is not selected
        webElementActionUtils.enterText(userSearchInput,username,10);
        webElementActionUtils.clickElement(userSearchResultFirstContact,10);

        return new TransactionPaymentPage(driver);
    }
}
