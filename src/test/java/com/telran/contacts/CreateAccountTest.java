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
        if (!isLoginLinkPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
            Assert.assertTrue(isElementPresent(By.cssSelector("login_login__3EHKB")));
        }
    }

    @Test
    public void registrationPositiveTest() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //fill registration form
        type(By.cssSelector("[placeholder='Email']"), "testfortest@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "AA1616aa_-q");
        //click on the button Registration
        click(By.xpath("//button[contains(.,'Registration')]"));
        //assert the button Sign out displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}


