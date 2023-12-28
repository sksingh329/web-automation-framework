package com.saucedemo.test.base;

import com.framework.core.web.selenium.driver.WebDriverFactory;
import com.saucedemo.app.flow.UserLoginLogoutFlow;
import com.saucedemo.app.pom.HomePage;
import com.saucedemo.app.pom.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected String appUrl = "https://www.saucedemo.com/";
    protected HomePage homePage;

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("defaultBrowserName") String browserName){
        if ("defaultBrowserName".equals(browserName)) {
            browserName = "chrome";
        }
        WebDriver driver = WebDriverFactory.getInstance().getDriver(browserName);
        driver.get(appUrl);
        LoginPage loginPage = new LoginPage(driver);
        homePage = UserLoginLogoutFlow.login(loginPage,"standard_user","secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        WebDriverFactory.getInstance().releaseDriver();
    }

    protected static double extractNumericValue(String currencyValue) {
        // Use regular expression to extract the numeric value from the currency string
        String numericValue = currencyValue.replaceAll("[^\\d.]", "");
        return Double.parseDouble(numericValue);
    }
}
