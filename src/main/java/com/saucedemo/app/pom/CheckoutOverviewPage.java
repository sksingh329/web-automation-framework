package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.WebElementActionUtils;
import com.saucedemo.app.products.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    private final WebDriver driver;
    public final MenuFragment menu;

    private final By finishButton = By.id("finish");
    private final By subTotalPriceLabel = By.xpath("//div[@class='summary_subtotal_label']");
    private final By cartItems = By.xpath("//div[@class='cart_item']");

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.menu = new MenuFragment(driver);
    }

    public ThankYouPage clickFinishButton(){
        webElementActionUtils.clickElement(finishButton,0);
        return new ThankYouPage(driver);
    }

    public String getSubTotalPriceLabel(){
        return webElementActionUtils.getLabelText(subTotalPriceLabel,0);
    }

    public List<ProductItem> getCartItems(){
        String productName, productDetail, productPrice;
        List<ProductItem> productItems = new ArrayList<>();
        List<WebElement> cartItemsElem = webElementActionUtils.findElements(cartItems,0);

        for(WebElement cartItem: cartItemsElem){
            productName = webElementActionUtils.getLabelText(cartItem.findElement(By.xpath(".//div[@class='inventory_item_name']")));
            productDetail = webElementActionUtils.getLabelText(cartItem.findElement(By.xpath(".//div[@class='inventory_item_desc']")));
            productPrice = webElementActionUtils.getLabelText(cartItem.findElement(By.xpath(".//div[@class='inventory_item_price']")));
            productItems.add(new ProductItem(productName,productDetail,productPrice));
        }
        return productItems;
    }
}
