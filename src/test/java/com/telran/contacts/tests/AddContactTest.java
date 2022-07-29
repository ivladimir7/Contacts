package com.telran.contacts.tests;


import com.telran.contacts.models.Contact;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviders;


public class AddContactTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }
        @Test
        public  void addContactPositiveTest() {
            app.getContact().AddContact();
//            Assert.assertTrue(app.getContact().isContactCreated("Amina"));
    }

    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lastName, String tel,
                                              String email, String city, String des) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().FillAddContactForm(new Contact().setName(name)
                .setLastName( lastName)
                .setTel(tel)
                .setEmail(email)
                .setCity(city)
                .setDescription(des));
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test(dataProvider = "addNewContactFromCSV",dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().FillAddContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }



    @AfterMethod
    public  void postCondition()
        {
        app. getContact().removeContact();
        }
}

