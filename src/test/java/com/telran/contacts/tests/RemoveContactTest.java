package com.telran.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
            app.getContact().AddContact();
        }
    }

    @Test
    public void removeContactTest()  {
        app.getContact().Pause(2000);
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().Pause(2000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter,sizeBefore -1);

    }

}





