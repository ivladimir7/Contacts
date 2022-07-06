package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    public int i;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isComponentFrmPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
        public boolean isElementPresent2(By loc) {
        try {
            driver.findElement(loc);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }


    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void login() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        type(By.cssSelector("[placeholder='Email']"), "testfortest@gmail.com");
        type(By.cssSelector("[placeholder='Password"), "AA1616aa_-q");
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickWithAction(By save) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);

        actions.moveToElement(element).perform();
        element.click();
    }

    public void AddContact() {
        int i= (int) (System.currentTimeMillis())/1000;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        FillAddContactForm(new Contact().setName("Amina").setLastName("Mashanlo").setTel("091631616").setEmail("ami").setEmail1("@test.de").setCity("Almaty").setCountry("Kasachstan"));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    private void FillAddContactForm(Contact contact) {
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

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void Pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Registration() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //fill registration form
        fillLoginRegistrationForm(new User().setEmail("testfortest@gmail.com").setPassword( "AA1616aa_-q"));
        //click on the button Registration
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    @AfterMethod(enabled = false)
    public void tearDown () {
        driver.quit();
    }
}

