package com.telran.contacts.tests;

import com.telran.contacts.fw.ContactHelper;
import com.telran.contacts.fw.HeaderHelper;
import com.telran.contacts.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;

    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

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
            if (browser.equals(BrowserType.CHROME)) {
                driver = new ChromeDriver();
            } else if(browser.equals(BrowserType.FIREFOX)) {
                driver = new FirefoxDriver();
            }
            driver.get("https://contacts-app.tobbymarshall815.vercel.app");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            user = new UserHelper(driver);
            contact = new ContactHelper(driver);
            header = new HeaderHelper(driver);

        }
}
