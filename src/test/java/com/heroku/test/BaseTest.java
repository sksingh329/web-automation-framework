package com.heroku.test;

import com.framework.core.web.selenium.driver.WebDriverFactory;
import com.heroku.app.pom.HomePage;
import com.saucedemo.app.flow.UserLoginLogoutFlow;
import com.saucedemo.app.pom.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected String appUrl = "https://the-internet.herokuapp.com/";
    protected HomePage homePage;

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("defaultBrowserName") String browserName){
        if ("defaultBrowserName".equals(browserName)) {
            browserName = "chrome";
        }
        WebDriver driver = WebDriverFactory.getInstance().getDriver(browserName);
        driver.get(appUrl);
        homePage = new HomePage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        WebDriverFactory.getInstance().releaseDriver();
    }
}
