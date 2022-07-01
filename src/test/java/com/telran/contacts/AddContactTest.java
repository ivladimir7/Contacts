package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginLinkPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        } else {
            login();
        }
    }
    @Test
    public  void addContactPositiveTest() {
        int i= (int) (System.currentTimeMillis())/1000;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        type(By.cssSelector("input:nth-child(1)"),"Amina");
        type(By.cssSelector("input:nth-child(2)"),"Machanlo");
        type(By.cssSelector("input:nth-child(3)"),"091631616" + i);
        type(By.cssSelector("input:nth-child(4)"),"ami" + i + "@test.de");
        type(By.cssSelector("input:nth-child(5)"),"Almaty");
        type(By.cssSelector("input:nth-child(6)"),"Kasachstan");
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
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
}

