package com.pageobject.tests;

import com.pageobject.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.pageobject.common.Constants.*;

public class LoginPageTests {

    @Test
    public void verifyUserOpensCorrectSite() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(userName);
        loginPage.typePassword(userPassword);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), url, "URL is incorrect");

        driver.quit();
    }

}
