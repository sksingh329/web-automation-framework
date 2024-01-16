package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionCompletePage extends BasePage {
    private final WebDriver driver;
    private By contactNameLabel = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']//h2)[1]");
    private By transactionDetailLabel = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item']//h2)[2]");

    public TransactionCompletePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getContactName(){
        return webElementActionUtils.getLabelText(contactNameLabel,10);
    }
    public String getTransactionDetail(){
        return webElementActionUtils.getLabelText(transactionDetailLabel,0);
    }
}
