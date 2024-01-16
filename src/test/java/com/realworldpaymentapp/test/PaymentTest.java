package com.realworldpaymentapp.test;

import com.realworldpaymentapp.app.pom.TransactionCompletePage;
import com.realworldpaymentapp.app.pom.TransactionPage;
import com.realworldpaymentapp.test.base.BaseTest;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    @Test
    public void MakePaymentTest() throws InterruptedException {
        TransactionPage transactionPage = homePage.getTopMenuFragment().clickMenuNewTransactionLink();
        Thread.sleep(5000);
        TransactionCompletePage transactionCompletePage = transactionPage.requestPayment("test","10","Pay for dinner");
        System.out.println(transactionCompletePage.getContactName());
        System.out.println(transactionCompletePage.getTransactionDetail());
    }
}
