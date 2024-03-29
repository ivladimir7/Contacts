package com.telran.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


      public class HeaderHelper extends HelperBase{
          public HeaderHelper(WebDriver driver) {
              super(driver);
          }


    public void isComponentFormPresent() {
        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isLoginLinkPresent() {
        return !isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }
}
