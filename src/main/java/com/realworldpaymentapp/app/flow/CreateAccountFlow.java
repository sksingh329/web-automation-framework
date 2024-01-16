package com.realworldpaymentapp.app.flow;

import com.framework.core.web.selenium.driver.WebDriverFactory;
import com.realworldpaymentapp.app.pom.SignUpPage;
import org.openqa.selenium.WebDriver;

public class CreateAccountFlow {
    //TODO - Get app url from properties
    protected final static String appUrl = "http://localhost:3000/";
    public static void createNewAccount(String firstName, String lastName, String username, String password){
        WebDriver driver = WebDriverFactory.getInstance().getDriver("chrome");
        driver.get(appUrl+"signup");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.doSignup(firstName,lastName,username,password,password);
        WebDriverFactory.getInstance().releaseDriver();
    }
}
