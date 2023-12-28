package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class MenuFragment extends BasePage {
    private final WebDriver driver;
    private final WebElementActionUtils webElementActionUtils;

    private final By menuDiv = By.xpath("//div[@class='bm-menu-wrap']");
    private final By openMenuButton = By.id("react-burger-menu-btn");
    private final By allItemsLink = By.linkText("All Items");
    private final By resetAppStateLink = By.linkText("Reset App State");
    private final By logoutLink = By.linkText("Logout");
    private final By cartItemCountLabel = By.xpath("//span[@class='shopping_cart_badge']");
    private final By cartLink = By.xpath("//div[@id='shopping_cart_container']/a");

    public MenuFragment(WebDriver driver){
        super(driver);
        this.driver = driver;
        webElementActionUtils = new WebElementActionUtils(driver);
    }

    private boolean isMenuOpen(){
        String ariaHidden = webElementActionUtils.getElementAttributeValue(menuDiv,"aria-hidden",0);
        return "true".equals(ariaHidden.toLowerCase(Locale.ROOT));
    }

    private MenuFragment clickOpenMenuButton(){
        if(isMenuOpen()){
            webElementActionUtils.clickElement(openMenuButton,0);
        }

        return new MenuFragment(driver);
    }

    public void clickAllItems(){
        clickOpenMenuButton();
        webElementActionUtils.clickElement(allItemsLink,0);
    }

    public void clickResetAppStateLink(){
        clickOpenMenuButton();
        webElementActionUtils.clickElement(resetAppStateLink,5);
    }

    public LoginPage clickLogout(){
        clickOpenMenuButton();
        webElementActionUtils.clickElement(logoutLink,5);
        return new LoginPage(driver);
    }

    public CartPage clickCartLink(){
        webElementActionUtils.clickElement(cartLink,0);
        return new CartPage(driver);
    }

    public String getCartItemCount(){
        try{
            return webElementActionUtils.getLabelText(cartItemCountLabel,0);
        }
        catch (NoSuchElementException ex){
            return "0";
        }
    }


}
