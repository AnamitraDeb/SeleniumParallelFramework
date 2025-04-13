package org.example.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.utils.ExtentReportManager;
import org.example.utils.ScreenshotManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormAuthenticationPages {

    WebDriver driver;

    public FormAuthenticationPages(WebDriver driver) {

        this.driver = driver;
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
        userNameTextField.sendKeys(username);
        ExtentReportManager.getTest().info("Entering username: "+ username,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
    }

    public void enterPassword(String password) {
        passwordTextField.sendKeys(password);
        ExtentReportManager.getTest().info("Entering password: "+ password,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
    }

    public void clickLoginButton() {
        loginButton.click();
        ExtentReportManager.getTest().info("Clicking on login button",
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
    }

    public String getBannerMessage() {
        ExtentReportManager.getTest().info("Fetching banner message:: " + banners.getText().split("\n")[0],
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        return banners.getText().split("\n")[0];
    }

    public String getWelcomeMessage() {
        ExtentReportManager.getTest().info("Fetching welcome message:: " + welcomeBanner.getText(),
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
        return welcomeBanner.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
        ExtentReportManager.getTest().info("Clicking on logout button",
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
    }
}
