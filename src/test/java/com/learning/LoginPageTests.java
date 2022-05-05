package com.learning;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learning.pages.LoginPage;

public class LoginPageTests extends TestNgTestBase {

    private LoginPage loginPage;

    @BeforeMethod
    public void gotoLoginPage() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testTitle() {
        Assert.assertEquals("Facebook - log in or sign up", loginPage.getTitle());
    }

    @Test
    public void testLoginWithNoPassword() {
        loginPage.login("username", "password");
        Assert.assertEquals("Facebook - log in or sign up", loginPage.getTitle());
    }
}
