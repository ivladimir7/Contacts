package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void AddContact() {
        int i= (int) (System.currentTimeMillis())/1000;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        FillAddContactForm(new Contact().setName("Amina").setLastName("Mashanlo").setTel("091631616").setEmail("ami").setEmail1("@test.de").setCity("Almaty").setCountry("Kasachstan"));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }


    public void FillAddContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        type(By.cssSelector("input:nth-child(3)"), contact.getTel() +i);
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail() + i + contact.getEmail1());
        type(By.cssSelector("input:nth-child(5)"), contact.getCity());
        type(By.cssSelector("input:nth-child(6)"), contact.getCountry());
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } return 0;
    }

    public void removeContact(){
        if(!isContactListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[contains(.,'Remove')]"));
        }

    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();

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
