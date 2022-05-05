package com.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class LoginPage extends Page {

    @FindBy(how = How.ID, using = "email")
    @CacheLookup
    public WebElement email;
    @FindBy(how = How.ID, using = "pass")
    @CacheLookup
    public WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@name='login']")
    @CacheLookup
    public WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(String username, String password) {
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.submit();
    }
}
