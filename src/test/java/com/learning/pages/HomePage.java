package com.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {
    @FindBy(how = How.LINK_TEXT, using = "Profile")
    @CacheLookup
    public WebElement profilePageLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
