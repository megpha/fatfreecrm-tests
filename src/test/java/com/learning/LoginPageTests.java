package com.learning;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.pages.LoginPage;

public class LoginPageTests extends TestNgTestBase {

    private LoginPage loginPage;

    @Test
    public void testTitle() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        Assert.assertEquals("Facebook - log in or sign up", loginPage.getTitle());
    }

    @Test
    public void testLoginWithNoPassword() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.login("username", "password");
        Assert.assertEquals("Facebook - log in or sign up", loginPage.getTitle());
    }
}
