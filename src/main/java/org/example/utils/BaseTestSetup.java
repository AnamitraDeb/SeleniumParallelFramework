package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestSetup {

    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
    protected static ThreadLocal<String> threadLocalBrowser = new ThreadLocal<String>();

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void driverSetup(String browser) {

        WebDriver driver = BrowserManager.browserSetUp(browser);
        threadLocalDriver.set(driver);
        threadLocalBrowser.set(browser);
        System.out.println("Thread ID: " + Thread.currentThread().getId());

        getDriver().get("https://the-internet.herokuapp.com/");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if(getDriver() != null) {
            getDriver().quit();
            System.out.println("Thread ID: " + Thread.currentThread().getId());
            threadLocalDriver.remove();
            threadLocalBrowser.remove();
        }
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static String getBrowser() {
        return threadLocalBrowser.get();
    }
}
