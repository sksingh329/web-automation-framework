package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPaymentPage extends BasePage {
    private final WebDriver driver;
    private final By amountInput = By.id("amount");
    private final By noteInput = By.id("transaction-create-description-input");
    private final By requestButton = By.xpath("//button[@data-test='transaction-create-submit-request']");
    private final By payButton = By.xpath("transaction-create-submit-payment");


    public TransactionPaymentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterAmount(String amount){
        webElementActionUtils.enterText(amountInput,amount,10);
    }
    public void enterNote(String note){
        webElementActionUtils.enterText(noteInput,note,0);
    }

    public TransactionCompletePage requestPayment(String amount, String note){
           enterAmount(amount);
           enterNote(note);
           webElementActionUtils.clickElement(requestButton,10);
           return new TransactionCompletePage(driver);
    }
}
