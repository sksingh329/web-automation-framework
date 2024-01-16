package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private final WebDriver driver;

    private final By usernameText = By.id("username");
    private final By passwordText = By.id("password");
    private final By signInButton = By.xpath("//button[@data-test='signin-submit']");
    private final By signupLink = By.xpath("//a[@data-test='signup']");

    public SignInPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public SignUpPage clickSignup(){
        webElementActionUtils.clickElement(signupLink,0);
        return new SignUpPage(driver);
    }

    public void enterUsername(String username){
        webElementActionUtils.enterText(usernameText,username,0);
    }
    public void enterPassword(String password){
        webElementActionUtils.enterText(passwordText,password,0);
    }
    public void clickSignIn(){
        webElementActionUtils.clickElement(signInButton,0);
    }

    public HomePage doLogin(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
        AccountPage accountPage = new AccountPage(driver);
        if(accountPage.isBankAccountDetailsPageDisplayed()){
            accountPage.submitBankAccountDetails("test1","123456789","123456789");
        }
        return new HomePage(driver);
    }

}
