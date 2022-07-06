package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            login();
        }
    }

    @Test
    public  void addContactPositiveTest() {
        AddContact();
        Assert.assertTrue(isContactCreated("Amina"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:contacts) {
            if (el.getText().contains(text)) ;
            return true;
        }
        return false;
        }
        @AfterMethod
    public  void postCondition()
        {
        removeContact();
        }
}

