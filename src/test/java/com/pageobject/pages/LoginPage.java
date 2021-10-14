package com.pageobject.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

     WebDriver driver;

     By emailInputField = By.xpath("//input[@id='email']");
     By passwordInputField = By.xpath("//input[@id='password']");
     By FORGOT_PASSWORD_LINK = By.xpath("//a[@id='loginForgotPassword']");
     By loginButton = By.xpath("//div[@id='page']/div[@class='loginForm']/div/input[@value='Login']");
     By emailIsRequired = By.xpath("//*[contains(@data-bind, 'email.errorText')]");
     By passwordIsRequired = By.xpath("//*[contains(@data-bind, 'password.errorText')]");

     public LoginPage(WebDriver driver){

         this.driver = driver;
         PageFactory.initElements(this.driver, this);

     }
//    public LoginPage() {
//         PageFactory.initElements(this.driver, this);
//    }


    public void typeEmail(String userName) {
        WebElement emailField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        emailField.sendKeys(userName);
        //return this;
    }


    public void typePassword(String password) {
        WebElement passwordField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordInputField));
        passwordField.sendKeys(password);
        //return this;
    }

    public void clickOnLoginButton() {
        WebElement passwordField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        passwordField.click();

        //return this;
    }
}
