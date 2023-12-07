package com.framework.core.web.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private static final WebDriverFactory instance = new WebDriverFactory();
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private WebDriverFactory(){}

    public static WebDriverFactory getInstance(){
        return instance;
    }

    public WebDriver getDriver(){
        if(threadLocal.get() == null) {
            WebDriver driver = new ChromeDriver();
            threadLocal.set(driver);
        }
        return threadLocal.get();
    }

    public void releaseDriver(){
        threadLocal.get().quit();
        threadLocal.remove();
    }

}
