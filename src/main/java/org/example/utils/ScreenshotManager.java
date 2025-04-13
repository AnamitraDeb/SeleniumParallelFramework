package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotManager {

    public static String getScreens(WebDriver driver) {
       String encodedString = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
       return encodedString;
    }
}
