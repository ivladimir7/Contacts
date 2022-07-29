package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviders;

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
        app.getUser().registration();;
        //assert the button Sign out displayed
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

    @Test(dataProvider = "RegistrationNegativeTestFromCSV",dataProviderClass = DataProviders.class)
    public void RegistrationNegativeTestFromCSV(User user) {
      app.getUser().click(By.xpath("//a[contains(.,'LOGIN')]"));
      app.getUser().fillLoginRegistrationForm(user); ;
      app.getUser().click(By.xpath("//button[contains(.,'Registration')]"));
      Assert.assertTrue(app.getUser().isAlertPresent());
    }
}


