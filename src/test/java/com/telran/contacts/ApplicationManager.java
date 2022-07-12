package com.telran.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;

    public HeaderHelper getHeader() {
        return header;
    }

    public UserHelper getUser() {
        return user;
    }
    public ContactHelper getContact () {
        return contact;
    }

        protected void init() {
            driver = new ChromeDriver();
            driver.get("https://contacts-app.tobbymarshall815.vercel.app");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            user = new UserHelper(driver);
            contact = new ContactHelper(driver);
            header = new HeaderHelper(driver);

        }
}
