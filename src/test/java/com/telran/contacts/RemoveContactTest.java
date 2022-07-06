package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            login();
            AddContact();
        }
    }

    @Test
    public void removeContactTest()  {
        Pause(2000);
        int sizeBefore = sizeOfContacts();
        removeContact();
        Pause(2000);
        int sizeAfter = sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter,sizeBefore -1);

    }

}





