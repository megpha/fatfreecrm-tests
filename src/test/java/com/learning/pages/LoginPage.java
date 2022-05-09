package com.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class LoginPage extends Page {

    @FindBy(how = How.ID, using = "user_email")
    @CacheLookup
    public WebElement email;
    @FindBy(how = How.ID, using = "user_password")
    @CacheLookup
    public WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    @CacheLookup
    public WebElement loginButton;
    @FindBy(how = How.LINK_TEXT, using = "Forgot Password?")
    @CacheLookup
    public WebElement forgotPasswordLink;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(String username, String password) {
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.submit();
    }

    public String getFlashMessage() {
        return this.driver.findElement(By.className("flash_notice")).getText();
    }
}
