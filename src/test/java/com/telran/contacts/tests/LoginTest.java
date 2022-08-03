package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getHeader().isLoginLinkPresent()) {
            app.driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));

        }
    }

    @Test
    public void loginUserPositiveTest() {
        //click on Login link
        app.getUser().login();
        //assert the button SignOut
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }
    @Test
    public void loginUserNegativeTest() {
        app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(new User().setEmail("jesse+982@mail.ru"));
        Assert.assertTrue(app.getUser().isAlertPresent());
        Assert.assertTrue(app.getUser().isErrorPresent());
    }

}

