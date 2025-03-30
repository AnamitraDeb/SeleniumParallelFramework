package org.example.pages;

import com.aventstack.extentreports.Status;
import org.example.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        ExtentReportManager.getTest().log(Status.INFO, "Entering username: "+ username);
        userNameTextField.sendKeys(username);
    }

    public void enterPassword(String password) {
        ExtentReportManager.getTest().log(Status.INFO, "Entering password: "+ password);
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        ExtentReportManager.getTest().log(Status.INFO, "Clicking on login button");
        loginButton.click();
    }

    public String getBannerMessage() {
        ExtentReportManager.getTest().log(Status.INFO, "Fetching banner message:: " + banners.getText().split("\n")[0]);
        return banners.getText().split("\n")[0];
    }

    public String getWelcomeMessage() {
        ExtentReportManager.getTest().log(Status.INFO, "Fetching welcome message:: " + welcomeBanner.getText());
        return welcomeBanner.getText();
    }

    public void clickLogoutButton() {
        ExtentReportManager.getTest().log(Status.INFO, "Clicking on logout button");
        logoutButton.click();
    }
}
