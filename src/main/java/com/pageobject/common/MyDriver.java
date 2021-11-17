package com.pageobject.common;

import com.properties.MyProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
    public static WebDriver driver;

    private MyDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
          System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }
}

