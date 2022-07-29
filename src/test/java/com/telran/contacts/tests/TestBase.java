package com.telran.contacts.tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    Logger logger = (Logger) LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        app.init();
    }


    @AfterMethod(enabled = false)
    public void tearDown () {
        app.driver.quit();
    }


    @BeforeMethod
    public void startTest(Method m,Object [] p) {
    logger.info(("Test start "+ m.getName() + "with data:" + " " + Arrays.asList(p)));
}
    @AfterMethod
    public void stopTest(){
        logger.info(("Test stop"));
    }
}
