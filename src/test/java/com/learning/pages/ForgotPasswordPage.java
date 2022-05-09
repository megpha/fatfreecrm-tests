package com.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends Page {

    @FindBy(how = How.ID, using = "passwords_submit")
    @CacheLookup
    public WebElement resetBtn;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
}
