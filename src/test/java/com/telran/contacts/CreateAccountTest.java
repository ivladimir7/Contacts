package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //precondition "user should be logged out
    // click on the Link Login
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
            Assert.assertTrue(app.isElementPresent(By.cssSelector("login_login__3EHKB")));
        }
    }

    @Test
    public void registrationPositiveTest() {
        app.getUser().Registration();
        //assert the button Sign out displayed
        Assert.assertTrue(app.isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}


