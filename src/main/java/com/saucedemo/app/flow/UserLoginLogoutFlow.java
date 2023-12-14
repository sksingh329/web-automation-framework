package com.saucedemo.app.flow;

import com.saucedemo.app.pom.HomePage;
import com.saucedemo.app.pom.LoginPage;

public class UserLoginLogoutFlow {
    public static HomePage login(LoginPage loginPage,String username, String password){
        return loginPage.validLogin(username,password);
    }
}
