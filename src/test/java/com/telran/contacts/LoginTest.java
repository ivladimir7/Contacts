package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));

        }
    }

    @Test
    public void loginUserPositiveTest() {
        //click on Login link
        login();
        //assert the button SignOut
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}

