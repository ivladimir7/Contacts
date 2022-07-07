package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        } else {
            app.login();
            app.AddContact();
        }
    }

    @Test
    public void removeContactTest()  {
        app.Pause(2000);
        int sizeBefore = app.sizeOfContacts();
        app.removeContact();
        app.Pause(2000);
        int sizeAfter = app.sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter,sizeBefore -1);

    }

}





