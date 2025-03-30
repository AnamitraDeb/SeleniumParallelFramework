package org.example.tests;

import org.example.constants.BannerStrings;
import org.example.pages.FormAuthenticationPages;
import org.example.pages.HomePage;
import org.example.utils.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTests extends BaseTestSetup {
    public HomePage homePage;
    public FormAuthenticationPages formAuthenticationPage;

    @Test(description = "Login with valid credentials")
    public void loginWithValidCredentials() {

        homePage = new HomePage(getDriver());
        formAuthenticationPage = homePage.goToFormAuthenticationPage();

        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");

        formAuthenticationPage.clickLoginButton();

        Assert.assertEquals(formAuthenticationPage.getBannerMessage(), BannerStrings.LOGINSUCCESS, "Login Failed");
        Assert.assertEquals(formAuthenticationPage.getWelcomeMessage(), BannerStrings.WELCOMEMESSAGE, "Login Failed");

        formAuthenticationPage.clickLogoutButton();
        Assert.assertEquals(formAuthenticationPage.getBannerMessage(), BannerStrings.LOGOUTSUCCESS, "Logout Failed");
    }
}
