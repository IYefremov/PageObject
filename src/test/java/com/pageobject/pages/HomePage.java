package com.pageobject.pages;

import com.pageobject.common.*;
import com.pageobject.common.menusItems.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomePage {
    @FindBy(xpath = "//ul[@id='mainMenu']/li")
    List<WebElement> listMainMenuElements;

    @FindBy(xpath = "//ul[@id='mainMenuOperations']/li")
    List<WebElement> listOperationElements;

    @FindBy(xpath = "//div[@id='menuBtn']")
    WebElement burgerIcon;

    @FindBy(xpath = "//span[@href='#mainMenuOperations']")
    WebElement operationsMenu;

    @FindBy(xpath = "//span[@href='#mainMenuSettings']")
    WebElement settingsMenu;

    @FindBy(xpath = "//ul[@id='mainMenuSettings']//a")
    List<WebElement> listSettingsElements;

    @FindBy(xpath = "//span[@href='#orders']")
    WebElement monitorMenu;

    @FindBy(xpath = "//ul[@id='orders']//li")
    List<WebElement> listMonitorElements;

    @FindBy(xpath = "//span[@href='#mainMenuIntegrations']")
    WebElement integrationMenu;

    @FindBy(xpath = "//ul[@id='mainMenuIntegrations']//li")
    List<WebElement> listIntegrationElements;

    @FindBy(xpath = "//div[@id='helpMenu']")
    WebElement helpButton;

    @FindBy(xpath = "//i[@class='icon-learn']")
    WebElement learnButton;

    public HomePage() {
        PageFactory.initElements(MyDriver.getDriver(), this);
    }

    public HomePage clickOnBurgerIcon() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOf(burgerIcon));
        burgerIcon.click();
        return this;
    }

    public HomePage clickOnOperationsMenu() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOf(operationsMenu));
        operationsMenu.click();
        return this;
    }

    public boolean isListOfOperationsMenuCorrect() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfAllElements(listOperationElements));

        return Utilites.areTwoListsEqual(listOperationElements, Arrays.asList(Operations.values()));
    }

    public boolean isListOfMainMenuElementsCorrect() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfAllElements(listMainMenuElements));

        return Utilites.areTwoListsEqual(listMainMenuElements,
                Arrays.asList(Main.values()));

    }

    public HomePage clickOnSettingsMenu() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOf(settingsMenu));
        settingsMenu.click();
        return this;
    }

    public boolean isListOfSettingsMenuCorrect() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfAllElements(listSettingsElements));

        return Utilites.areTwoListsEqual(listSettingsElements,
                Arrays.asList(Settings.values()));
    }

    public HomePage clickOnMonitorMenu() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(monitorMenu)));

        Actions actions = new Actions(MyDriver.getDriver());
        actions.moveToElement(monitorMenu).build().perform();

        wait.until(ExpectedConditions.visibilityOf(monitorMenu));
        monitorMenu.click();
        return this;
    }

    public boolean isListOfMonitorMenuCorrect() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfAllElements(listMonitorElements));

        return Utilites.areTwoListsEqual(listMonitorElements,
                Arrays.asList(Monitor.values()));
    }


    public HomePage clickOnIntegrationsMenu() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        //wait.until(ExpectedConditions.visibilityOf(integrationMenu));
        wait.until(ExpectedConditions.elementToBeClickable(integrationMenu));

        integrationMenu.click();
        return this;
    }

    public boolean isListOfIntegrationMenuCorrect() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfAllElements(listIntegrationElements));

        return Utilites.areTwoListsEqual(listIntegrationElements,
                Arrays.asList(Integrations.values()));
    }

    public HomePage clickOnHelpButton() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(helpButton));

        helpButton.click();
        return this;
    }

    public HomePage switchToHelpNewBrowserTab() {
        List<String> browserTabs = new ArrayList<String>(MyDriver.getDriver().getWindowHandles());
        MyDriver.getDriver().switchTo().window(browserTabs.get(1));
        return this;
    }

    public HomePage closeTabAndReturnToTheHomePageTab() {
        List<String> browserTabs = new ArrayList<String>(MyDriver.getDriver().getWindowHandles());
        MyDriver.getDriver().switchTo().window(browserTabs.get(1)).close();
        MyDriver.getDriver().switchTo().window(browserTabs.get(0));
        return this;
    }

    public HomePage clickOnLearnButton() {
        Actions action = new Actions(MyDriver.getDriver());
        action.moveToElement(helpButton).perform();

        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 1);
        wait.until(ExpectedConditions.elementToBeClickable(learnButton));
        learnButton.click();
        return this;
    }

    public HomePage switchToLearnNewBrowserTab() {
        List<String> browserTabs = new ArrayList<String>(MyDriver.getDriver().getWindowHandles());
        MyDriver.getDriver().switchTo().window(browserTabs.get(1));
        return this;
    }
}
