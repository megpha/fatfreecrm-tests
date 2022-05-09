package com.learning;

import com.learning.pages.ForgotPasswordPage;
import com.learning.pages.HomePage;
import com.learning.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTests extends TestNgTestBase {

    private LoginPage loginPage;

    @Test
    public void testTitle() {
        loginPage = new LoginPage(driver);
        Assert.assertEquals("Fat Free CRM", loginPage.getTitle());
    }

    @Test
    public void testValidUserNamePasswordWithJS() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithJs("admin", "admin");
        HomePage homePage = new HomePage(driver);
        Assert.assertNotNull(homePage.profilePageLink);
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
