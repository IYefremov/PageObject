package com.pageobject.tests;

import com.pageobject.pages.LoginPage;
import com.properties.MyProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageobject.common.MyDriver;


public class LoginPageTests extends BaseTest {

    @DataProvider(name = "incorrectOrNotFullData")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"", MyProperties.getProperties("password")},
                {MyProperties.getProperties("username"), ""},
                {MyProperties.getProperties("username")+"pref",
                        MyProperties.getProperties("password") + "pref"},
                {"", ""}
        };
    }

    @Test (dataProvider = "incorrectOrNotFullData")
    public void userCantLoginWithIncorrectOrNotFullData(String userName, String password) {
        Boolean isErrorMessageDisplayed = new LoginPage()
                .openLoginURL(MyProperties.getProperties("baseURL"))
                .typeEmail(userName)
                .typePassword(password)
                .clickOnLoginButton()
                .isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed,
                "'Login is required' or 'Password is required' message is not displayed`");
    }

    @Test
    public void verifyUserOpensCorrectSite() {
        new LoginPage()
                .openLoginURL(MyProperties.getProperties("baseURL"))
                .typeEmail(MyProperties.getProperties("username"))
                .typePassword(MyProperties.getProperties("password"))
                .clickOnLoginButton()
                .waitPageIsLoaded();
        Assert.assertTrue(MyDriver.getDriver().getCurrentUrl().contains("/home"), "URL is incorrect");
    }
}
