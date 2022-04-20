package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //find Register and click
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //find 'Register' text and store in string variable
        WebElement registerTextElement = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']"));
        String actualText = registerTextElement.getText();

        String expectedText = "Signing up is easy!";
        //validate actual and expected text
        Assert.assertEquals("Not found 'Signing up is easy!' text", expectedText, actualText);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find Register and click
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //find first name and send value
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id=\"customer.firstName\"]"));
        firstNameField.sendKeys("Kapil");
        //find last name and send value
        WebElement lastNameField = driver.findElement(By.name("customer.lastName"));
        lastNameField.sendKeys("Patel");
        //find address field and send value
        WebElement addressField = driver.findElement(By.id("customer.address.street"));
        addressField.sendKeys("11,Xy Street");
//find city field and send value
        WebElement cityFeild = driver.findElement(By.xpath("//input[@name='customer.address.city' or @id='customer.address.city']"));
        cityFeild.sendKeys("Colindale,London");
//find city field and send value
        WebElement stateFeild = driver.findElement(By.xpath("//input[@name='customer.address.state']"));
        stateFeild.sendKeys("N/A");
        //find ZipCode field and send values
        WebElement zipCodeField = driver.findElement(By.id("customer.address.zipCode"));
        zipCodeField.sendKeys("NW0 9FC");
        //find phone number field and send values
        WebElement companyField = driver.findElement(By.name("customer.phoneNumber"));
        companyField.sendKeys("7456908204");
        //find SSN and send values
        WebElement ssnField = driver.findElement(By.name("customer.ssn"));
        ssnField.sendKeys("n/a");
        //find userName and send values
        WebElement userName = driver.findElement(By.name("customer.username"));
        userName.sendKeys("Kapil123");
        //find password field and send values
        WebElement passwordField = driver.findElement(By.name("customer.password"));
        passwordField.sendKeys("Find@12");
        //find confirm password field and send values
        WebElement confirmPassword = driver.findElement(By.name("repeatedPassword"));
        confirmPassword.sendKeys("Find@12");
        //find Register button and click
        WebElement registerButton = driver.findElement(By.xpath("(//input[@class=\"button\"])[2]"));
        registerButton.click();

        WebElement registerConfirmElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in')]"));
        String actualText = registerConfirmElement.getText();

        String expectedText = "Your account was created successfully You are now logged in.";
        //validate actual and expected text
        Assert.assertEquals("Not found 'Your account was created successfully. You are now logged in.", expectedText, actualText);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }


}
