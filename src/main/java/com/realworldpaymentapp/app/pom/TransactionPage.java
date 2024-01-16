package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage extends BasePage {
    private final WebDriver driver;
    private final By transactionAmountInput = By.id("amount");
    private final By transactionNoteInput = By.id("transaction-create-description-input");


    public TransactionPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public TransactionCompletePage requestPayment(String username, String amount, String note){
        TransactionPaymentPage paymentPage = new TransactionSelectContactPage(driver).selectContact(username);
        return paymentPage.requestPayment(amount,note);
    }
}
