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

public class HomePage {

        WebDriver driver;
        private static Logger logger;

        public HomePage(WebDriver driver) {
            this.driver = driver;
            ThreadContext.put("browser", BaseTestSetup.getBrowser());
            logger = LogManager.getLogger(HomePage.class);
            PageFactory.initElements(driver, this);
        }

        @FindBy(linkText = "Form Authentication")
        private WebElement formAuthentication;

        @FindBy(linkText = "Shadow DOM")
        private WebElement shadowDom;


        public FormAuthenticationPages goToFormAuthenticationPage() {
            try{
                formAuthentication.click();
                logger.info("Navigating to Form Authentication Page");
                ExtentReportManager.getTest().info("Navigating to Form Authentication Page",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
                return new FormAuthenticationPages(driver);
            }
            catch (Exception e) {
                logger.error("Failed Navigating to Form Authentication Page " ,e);
                ExtentReportManager.getTest().log(Status.FAIL, "Failed to Navigate to Form Authentication Page", e,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotManager.getScreens(driver)).build());
                return null;
            }
        }
    }