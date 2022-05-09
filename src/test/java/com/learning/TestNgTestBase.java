package com.learning;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

    protected static String baseUrl = "https://qafatfreecrm.herokuapp.com/";
    protected static URL gridHubUrl;
    protected static DesiredCapabilities capabilities;

    protected WebDriver driver;

    @BeforeTest
    public void initWebDriver() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    @BeforeSuite
    public void initTestSuite() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        gridHubUrl = new URL("http://192.168.1.85:4444/wd/hub");
    }

}
