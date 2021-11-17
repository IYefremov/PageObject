package com.pageobject.tests;

import com.pageobject.common.MyDriver;
import com.pageobject.pages.HomePage;
import com.pageobject.pages.LoginPage;
import com.properties.MyProperties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @BeforeMethod
    public void checkIfHomePageIsDisplayedAndLoadIfNot() {
        if (!MyDriver.getDriver().getCurrentUrl().equals(MyProperties.getProperties("homePageURL"))) {
            new LoginPage()
                    .openLoginURL(MyProperties.getProperties("baseURL"))
                    .typeEmail(MyProperties.getProperties("username"))
                    .typePassword(MyProperties.getProperties("password"))
                    .clickOnLoginButton()
                    .waitPageIsLoaded();
        }
    }

    @Test (priority = 0)
    public void verifyMainMenuHasFullSetOfSections() {
        HomePage homePage = new HomePage();

        boolean isListCorrect = homePage
                .clickOnBurgerIcon()
                .isListOfMainMenuElementsCorrect();
        Assert.assertTrue(isListCorrect, "The names or quantity of main menu elements is NOT correct ");

        isListCorrect = homePage
                .clickOnOperationsMenu()
                .isListOfOperationsMenuCorrect();
        Assert.assertTrue(isListCorrect, "The names or quantity of Operations menu elements is NOT correct ");

        isListCorrect = homePage
                .clickOnSettingsMenu()
                .isListOfSettingsMenuCorrect();
        Assert.assertTrue(isListCorrect, "The names or quantity of Settings menu elements is NOT correct ");

        isListCorrect = homePage
                .clickOnMonitorMenu()
                .isListOfMonitorMenuCorrect();
        Assert.assertTrue(isListCorrect, "The names or quantity of Monitor menu elements is NOT correct ");

        isListCorrect = homePage
                .clickOnIntegrationsMenu()
                .isListOfIntegrationMenuCorrect();
        Assert.assertTrue(isListCorrect, "The names or quantity of Integrations menu elements is NOT correct ");
    }

    @Test (priority = 0)
    public void verifyCorrectLinkIsOpenedWhenClickHelpButton() {

        HomePage homePage = new HomePage();
        homePage
                .clickOnHelpButton()
                .switchToHelpNewBrowserTab();
        Assert.assertTrue(MyDriver.getDriver().getCurrentUrl().contains("https://intercom.help/amt"),
                "Incorrect link is opened after the Help button clicking");
        homePage.closeTabAndReturnToTheHomePageTab();
    }

    @Test (invocationCount = 1)
    public void verifyCorrectLinkIsOpenedWhenClickLearnButton() {

        HomePage homePage = new HomePage();
        homePage
                .clickOnLearnButton()
                .switchToLearnNewBrowserTab();
        Assert.assertTrue(MyDriver.getDriver().getCurrentUrl().contains("college.amt360"),
                "Incorrect link is opened after the Learn button clicking");
        homePage.closeTabAndReturnToTheHomePageTab();
    }
}

