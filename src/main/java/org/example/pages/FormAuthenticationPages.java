package org.example.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.example.utils.BaseTestSetup;
import org.example.utils.ExtentReportManager;
import org.example.utils.ScreenshotManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPages {

    private static Logger logger;
    WebDriver driver;

    public FormAuthenticationPages(WebDriver driver) {
        this.driver = driver;
        ThreadContext.put("browser", BaseTestSetup.getBrowser());
        logger = LogManager.getLogger(FormAuthenticationPages.class);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement userNameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@class='radius']")
    private WebElement loginButton;

    @FindBy(css = "i.icon-signout")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[contains(@class, 'flash')]")
    private WebElement banners;

    @FindBy(tagName = "h4")
    private WebElement welcomeBanner;

    public void enterUsername(String username) {
        try{
            userNameTextField.sendKeys(username);
            logger.info("Entering username: {}", username);
            ExtentReportManager.getTest().info("Entering username: "+ username,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        } catch (Exception e) {
            logger.error("Failed Entering username: {}", username, e);
            ExtentReportManager.getTest().log(Status.FAIL, "Entering username: "+ username, e,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        }
    }

    public void enterPassword(String password) {
        try{
            passwordTextField.sendKeys(password);
            logger.info("Entering password: {}", password);
            ExtentReportManager.getTest().info("Entering password: "+ password,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        } catch (Exception e) {
            logger.error("Failed Entering password: {}", password, e);
            ExtentReportManager.getTest().log(Status.FAIL, "Entering password: "+ password, e,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        }
    }

    public void clickLoginButton() {
        try {
            loginButton.click();
            logger.info("Clicking on login button");
            ExtentReportManager.getTest().info("Clicking on login button",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());

        } catch (Exception e) {
            logger.error("Failed Clicking on login button");
            ExtentReportManager.getTest().log(Status.FAIL, "Clicking on login button", e,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        }
    }

    public String getBannerMessage() {

        String bannerMessage = "";
        try {
           bannerMessage =  banners.getText().split("\n")[0];
           logger.info("Fetching banner message:: {}", bannerMessage);
            ExtentReportManager.getTest().info("Fetching banner message:: " + bannerMessage,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());

        } catch (Exception e) {
            logger.error("Failed Fetching Banner message:: " ,e);
            ExtentReportManager.getTest().log(Status.FAIL, "Failed to Fetch banner message",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        }
        return bannerMessage;
    }

    public String getWelcomeMessage() {

        String welcomeMessage = "";
        try {
            welcomeMessage =  welcomeBanner.getText();
            logger.info("Fetching welcome message:: {}", welcomeMessage);
            ExtentReportManager.getTest().info("Fetching welcome message:: " + welcomeMessage,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        } catch (Exception e) {
            logger.error("Failed Fetching welcome message:: ", e);
            ExtentReportManager.getTest().log(Status.FAIL, "Failed to Fetch welcome message:: ", e,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        }
        return welcomeMessage;
    }

    public void clickLogoutButton() {
        try {
            logoutButton.click();
            logger.info("Clicking on logout button");
            ExtentReportManager.getTest().info("Clicking on logout button",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        } catch (Exception e) {
            logger.error("Failed Clicking on logout button");
            ExtentReportManager.getTest().log(Status.FAIL, "Clicking on logout button", e,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        }
    }
}