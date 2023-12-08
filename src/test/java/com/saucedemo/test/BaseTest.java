package com.saucedemo.test;

import com.framework.core.web.selenium.WebDriverFactory;
import com.saucedemo.app.pom.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected String appUrl = "https://www.saucedemo.com/";
    protected LoginPage loginPage;

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("defaultBrowserName") String browserName){
        if ("defaultBrowserName".equals(browserName)) {
            browserName = "chrome";
        }
        WebDriver driver = WebDriverFactory.getInstance().getDriver(browserName);
        driver.get(appUrl);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        WebDriverFactory.getInstance().releaseDriver();
    }
}
