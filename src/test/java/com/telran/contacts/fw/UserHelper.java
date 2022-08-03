package com.telran.contacts.fw;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void registration() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //fill registration form
        fillLoginRegistrationForm(new User().setEmail("testfortest88@gmail.com").setPassword( "AA1616aa_-q"));
        //click on the button Registration
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void login() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        type(By.cssSelector("[placeholder='Email']"), "testfortest@gmail.com");
        type(By.cssSelector("[placeholder='Password"), "AA1616aa_-q");
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public boolean isErrorPresent() {
        return isElementPresent(By.xpath("//div[.='Login Failed with code 400']"));
    }
}
