package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //precondition "user should be logged out

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
            Assert.assertTrue(app.getHeader().isElementPresent(By.cssSelector("login_login__3EHKB")));
        }
    }

    @Test
    public void registrationPositiveTest() {
        // click on the Link Login
        app.getUser().Registration();
        //assert the button Sign out displayed
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}


