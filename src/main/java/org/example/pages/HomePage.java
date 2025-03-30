package org.example.pages;

import com.aventstack.extentreports.Status;
import org.example.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

        WebDriver driver;

        public HomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(linkText = "Form Authentication")
        private WebElement formAuthentication;

        public FormAuthenticationPages goToFormAuthenticationPage() {
            ExtentReportManager.getTest().log(Status.INFO, "Navigating to Form Authentication Page");
            formAuthentication.click();
            return new FormAuthenticationPages(driver);
        }
    }