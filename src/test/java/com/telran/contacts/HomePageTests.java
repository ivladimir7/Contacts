package com.telran.contacts;

import org.testng.annotations.Test;


public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {
        System.out.println("Site opened!!!");
        app.isComponentFrmPresent();
    }

}