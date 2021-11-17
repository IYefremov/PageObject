package com.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pageobject.common.MyDriver;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/*
Page Object представляет собой отдельный класс, содержащий локаторы элементов,
методы для работы с ними и конструктор принимающий в качестве параметра объект WebDriver
http://internetka.in.ua/selenium-page-object/
*/
public class LoginPage {

    private By elem = By.className("loginForm");

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//div[@autocomplete='off']//input[@type='button']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='login user-info__block']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[contains(@data-bind, 'hasError')]")
    List<WebElement> listErrMess;

    public LoginPage() {
        PageFactory.initElements(MyDriver.getDriver(), this);
    }

    public LoginPage typeEmail(String userName) {
        WebElement emailField = new WebDriverWait(MyDriver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(emailInput));
        emailField.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement passwordField = new WebDriverWait(MyDriver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        WebElement passwordField = new WebDriverWait(MyDriver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(loginButton));
        passwordField.click();
        return this;
    }

    public LoginPage openLoginURL(String loginURL) {
        MyDriver.getDriver().get(loginURL);
        MyDriver.getDriver().manage().window().maximize();
        return this;
    }

    public LoginPage waitPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 40);
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(logoutLink)));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        return this;
    }

    public boolean isErrorMessageDisplayed() {

        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfAllElements(listErrMess));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }

        System.out.println(listErrMess.size());
        for (WebElement elementOfList : listErrMess) {
            if (elementOfList.getAttribute("style").isEmpty()) {
                System.out.println(elementOfList.findElement(By.tagName("span")).getText());
                return true;
            }
        }
        return false;
    }
}