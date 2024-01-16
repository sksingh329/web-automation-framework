package com.realworldpaymentapp.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    private WebDriver driver;
    private final By firstNameText = By.id("firstName");
    private final By lastNameText = By.id("lastName");
    private final By usernameText = By.id("username");
    private final By passwordText = By.id("password");
    private final By confirmPasswordText = By.id("confirmPassword");
    private final By signupButton = By.xpath("//button[@data-test='signup-submit']");

    public SignUpPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterFirstName(String firstName){
        webElementActionUtils.enterText(firstNameText,firstName,0);
    }

    public void enterLastName(String lastName){
        webElementActionUtils.enterText(lastNameText,lastName,0);
    }

    public void enterUsername(String username){
        webElementActionUtils.enterText(usernameText,username,0);
    }

    public void enterPassword(String password){
        webElementActionUtils.enterText(passwordText,password,0);
    }

    public void enterConfirmPassword(String confirmPassword){
        webElementActionUtils.enterText(confirmPasswordText,confirmPassword,0);
    }

    public void clickSignupButton(){
        webElementActionUtils.clickElement(signupButton,0);
    }

    public void doSignup(String firstName, String lastName, String username, String password, String confirmPassword){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickSignupButton();
    }
}
