package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private final WebDriver driver;
    private final By nextButton = By.xpath("//button[@data-test='user-onboarding-next']");
    private final By bankNameInput = By.id("bankaccount-bankName-input");
    private final By routingNumberInput = By.id("bankaccount-routingNumber-input");
    private final By accountNumberInput = By.id("bankaccount-accountNumber-input");
    private final By saveButton = By.xpath("//button[@data-test='bankaccount-submit']");
    private final By doneButton = By.xpath("//button[@data-test='user-onboarding-next']/span[text()='Done']");

    public AccountPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean isBankAccountDetailsPageDisplayed(){
        return webElementActionUtils.isDisplayed(nextButton,10);
    }

    public void submitBankAccountDetails(String bankName, String routingNumber, String accountNumber){
        webElementActionUtils.clickElement(nextButton,10);
        webElementActionUtils.enterText(bankNameInput,bankName,10);
        webElementActionUtils.enterText(routingNumberInput,routingNumber,0);
        webElementActionUtils.enterText(accountNumberInput,accountNumber,0);
        webElementActionUtils.clickElement(saveButton,10);
        webElementActionUtils.clickElement(doneButton,10);
    }

}
