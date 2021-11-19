package com.pageobject.tests;

import com.pageobject.common.MyDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        MyDriver.getDriver().quit();
    }
}

// почитать о бефор или афтер методы
// переход на сайт в рамках теста
// продумать файл с данными
// добавить проверку на пейдж-спесифик айкон

