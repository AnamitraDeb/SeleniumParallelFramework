package org.example.pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShadowDomPage {
    WebDriver driver;

    public ShadowDomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "my-paragraph:nth-of-type(1)")
    private WebElement firstParagraphShadowHost;

    public SearchContext getFirstParagraphShadowRoot() {
        SearchContext shadowRoot = firstParagraphShadowHost.getShadowRoot();
        return shadowRoot;
    }
}
