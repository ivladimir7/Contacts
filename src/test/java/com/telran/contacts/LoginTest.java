package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));

        }
    }

    @Test
    public void loginUserPositiveTest() {
        //click on Login link
        app.getUser().login();
        //assert the button SignOut
        Assert.assertTrue(app.isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}

