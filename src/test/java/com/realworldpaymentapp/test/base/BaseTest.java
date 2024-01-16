package com.realworldpaymentapp.test.base;

import com.framework.core.web.selenium.driver.WebDriverFactory;
import com.realworldpaymentapp.app.flow.CreateAccountFlow;
import com.realworldpaymentapp.app.pom.HomePage;
import com.realworldpaymentapp.app.pom.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected String appUrl = "http://localhost:3000/";
    protected SignInPage signInPage;
    private final String username = "test";
    private final String password = "test";
    protected HomePage homePage;

    @BeforeTest
    public void createAccount(){
        CreateAccountFlow.createNewAccount(username,username,username,password);
    }

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("defaultBrowserName") String browserName){
        if ("defaultBrowserName".equals(browserName)) {
            browserName = "chrome";
        }
        WebDriver driver = WebDriverFactory.getInstance().getDriver(browserName);
        driver.get(appUrl);
        signInPage = new SignInPage(driver);
        homePage = signInPage.doLogin(username,password);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        WebDriverFactory.getInstance().releaseDriver();
    }
}
