package com.telran.contacts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }


    @AfterMethod(enabled = false)
    public void tearDown () {
        app.driver.quit();
    }
}

