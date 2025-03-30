package org.example.tests;

import org.example.constants.BannerStrings;
import org.example.pages.FormAuthenticationPages;
import org.example.pages.HomePage;
import org.example.utils.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTests extends BaseTestSetup {

    public HomePage homePage;
    public FormAuthenticationPages formAuthenticationPage;

    @Test(description = "Login with invalid username")
    public void loginWithInvalidUserName() {
        homePage = new HomePage(getDriver());
        formAuthenticationPage = homePage.goToFormAuthenticationPage();

        formAuthenticationPage.enterUsername("Anamitra");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");

        formAuthenticationPage.clickLoginButton();
        Assert.assertEquals(formAuthenticationPage.getBannerMessage(), BannerStrings.INVALIDUSERNAMEMESSAGE);
    }

    @Test(description = "Login with invalid password")
    public void loginWithInvalidPasssword() {

        homePage = new HomePage(getDriver());
        formAuthenticationPage = homePage.goToFormAuthenticationPage();

        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword");

        formAuthenticationPage.clickLoginButton();
        Assert.assertEquals(formAuthenticationPage.getBannerMessage(), BannerStrings.INVALIDPASSWORDMESSAGE);
    }

}
