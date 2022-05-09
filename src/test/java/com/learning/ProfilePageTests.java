package com.learning;

import com.learning.pages.HomePage;
import com.learning.pages.LoginPage;
import com.learning.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestNgTestBase {
    @BeforeTest
    public void gotoProfilePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");
        HomePage homePage = new HomePage(driver);
        homePage.profilePageLink.click();
    }

    @Test
    public void testTitle() {
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertEquals("Fat Free CRM", profilePage.getTitle());
    }

}
