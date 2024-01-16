package com.saucedemo.app.pom;

import com.framework.core.web.selenium.base.BasePage;
import com.framework.core.web.selenium.element.HandleDropdown;
import com.saucedemo.app.products.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    private final WebDriver driver;
    private final MenuFragment menu;

    private final By productDiv = By.xpath("//div[@class='inventory_item_description']");
    private final By productSortDropDown = By.xpath("//select[@data-test='product_sort_container']");

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.menu = new MenuFragment(driver);
    }

    public MenuFragment getMenu(){
        return menu;
    }

    public ProductDetailsPage clickProduct(String productName){
        webElementActionUtils.clickElement(By.linkText(productName),0);
        return new ProductDetailsPage(driver);
    }

    public void sortProduct(String sortType){
        webElementActionUtils.getHandleDropdown().selectBy(webElementActionUtils.findElement(productSortDropDown,0), HandleDropdown.SelectBy.text, sortType);
    }

    public List<ProductItem> getProducts(){
        String productName, productDetail, productPrice;
        List<ProductItem> productItems = new ArrayList<>();
        List<WebElement> cartItemsElem = webElementActionUtils.findElements(productDiv,0);

        for(WebElement cartItem: cartItemsElem){
            productName = webElementActionUtils.getLabelText(cartItem.findElement(By.xpath(".//div[@class='inventory_item_name ']")));
            productDetail = webElementActionUtils.getLabelText(cartItem.findElement(By.xpath(".//div[@class='inventory_item_desc']")));
            productPrice = webElementActionUtils.getLabelText(cartItem.findElement(By.xpath(".//div[@class='inventory_item_price']")));
            productItems.add(new ProductItem(productName,productDetail,productPrice));
        }
        return productItems;
    }

}
