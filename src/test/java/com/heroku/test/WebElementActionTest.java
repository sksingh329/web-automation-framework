package com.heroku.test;

import com.heroku.app.pom.AlertPage;
import com.heroku.app.pom.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElementActionTest extends BaseTest{
    @Test
    public void checkboxCountTest(){
        CheckboxesPage checkboxesPage = homePage.clickCheckboxesLink();
        //Get all checkboxes count on the page
        Assert.assertEquals(checkboxesPage.getCheckboxCount(),2);
    }
    @Test
    public void firstCheckboxIsNotCheckedTest(){
        CheckboxesPage checkboxesPage = homePage.clickCheckboxesLink();
        Assert.assertFalse(checkboxesPage.isCheckboxSelected("first"));
    }
    @Test
    public void selectFirstCheckboxTest(){
        CheckboxesPage checkboxesPage = homePage.clickCheckboxesLink();
        if(!checkboxesPage.isCheckboxSelected("first")){
            checkboxesPage.clickFirstCheckbox();
        }
        Assert.assertTrue(checkboxesPage.isCheckboxSelected("first"));
    }
    @Test
    public void unselectSecondCheckboxTest(){
        CheckboxesPage checkboxesPage = homePage.clickCheckboxesLink();
        if(checkboxesPage.isCheckboxSelected("second")){
            checkboxesPage.clickSecondCheckbox();
        }
        Assert.assertFalse(checkboxesPage.isCheckboxSelected("second"));
    }
    @Test
    public void acceptAlertTest(){
        AlertPage alertPage = homePage.clickAlertLink();
        alertPage.setClickForJsAlertButton();
        alertPage.acceptAlert();
        Assert.assertEquals(alertPage.getResult(),"You successfully clicked an alert");
    }
}
