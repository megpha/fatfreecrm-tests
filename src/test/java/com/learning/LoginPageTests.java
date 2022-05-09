package com.learning;

import com.learning.pages.ForgotPasswordPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.*;

import com.learning.pages.LoginPage;

public class LoginPageTests extends TestNgTestBase {

    private LoginPage loginPage;

    @BeforeTest
    public void initWebDriver() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void testTitle() {
        loginPage = new LoginPage(driver);
        Assert.assertEquals("Fat Free CRM", loginPage.getTitle());
    }

    @Test
    public void testForgotPasswordPage() {
        loginPage = new LoginPage(driver);
        loginPage.forgotPasswordLink.click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(this.driver);
        Assert.assertEquals("Fat Free CRM", forgotPasswordPage.getTitle());
    }

    @Test
    public void testInvalidUserName() {
        driver.get(baseUrl + "users/sign_in");
        loginPage = new LoginPage(driver);
        loginPage.login("user", "admin");
        Assert.assertEquals("Invalid Email or password.", loginPage.getFlashMessage());
    }

    @Test
    public void testInvalidPassword() {
        driver.get(baseUrl + "users/sign_in");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "password");
        Assert.assertEquals("Invalid Email or password.", loginPage.getFlashMessage());
    }

    @DataProvider(name = "credentials")
    public Object[][] userNamePasswords() {
        return new Object[][]{
                {"admin", "badpassword"},
                {" ", " "},
                {" ", "password"},
                {"admin", ""}
        };
    }

    @Test(dataProvider = "credentials")
    public void testBadAuthentication(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        Assert.assertEquals("Invalid Email or password.", loginPage.getFlashMessage());
    }
}
