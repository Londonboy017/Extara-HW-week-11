package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
//find username filed and sen values
        WebElement userNameField = driver.findElement(By.xpath("//input[@name=\"username\"]"));//store in WebElement by id
        userNameField.sendKeys("Kapil123");///Sending email to email filed element
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.xpath("//input[@name=\"password\"]"));//Store in webelement by name
        passwordFeild.sendKeys("Find@123"); //Sending password to password filed element

//find login element and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Log In\"]"));
        loginButton.click();
        //find 'Account overview' text
        WebElement actualMessageElement = driver.findElement(By.tagName("h1"));
        String actualMessage = actualMessageElement.getText();

        String expectedMessage = "Accounts Overview";
        //validate actual and expected text
        Assert.assertEquals("'Accounts Overview' text not found ", expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage() {
        //find username element
        WebElement userNameField = driver.findElement(By.xpath("//input[@name=\"username\"]"));//store in WebElement by id
        userNameField.sendKeys("london23");///Sending email to email filed element
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.xpath("//input[@name=\"password\"]"));//Store in webelement by name
        passwordFeild.sendKeys("Hind$123"); //Sending password to password filed element

    //find login element and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Log In\"]"));
        loginButton.click();
        //find error text element
        WebElement actualMessageElement = driver.findElement(By.tagName("h1"));
        String actualMessage = actualMessageElement.getText();

        String expectedMessage = "The username and password could not be verified.";
        //validate actual and expected text
        Assert.assertEquals("'The username and password could not be verified.' text not found ", expectedMessage, actualMessage);
    }
@Test
public void userShouldLogOutSuccessfully(){
//find username filed and sen values
    WebElement userNameField = driver.findElement(By.xpath("//input[@name=\"username\"]"));//store in WebElement by id
    userNameField.sendKeys("Kapil123");///Sending email to email filed element
    //to find the password field element
    WebElement passwordFeild = driver.findElement(By.xpath("//input[@name=\"password\"]"));//Store in webelement by name
    passwordFeild.sendKeys("Find@123"); //Sending password to password filed element

//find login element and click
    WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Log In\"]"));
    loginButton.click();
    //find logout element and click
    WebElement logout  = driver.findElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]"));
    logout.click();

    String expectedMessage = "Customer Login";
    WebElement actualMessageElement =driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
    String actualMessage=actualMessageElement.getText();
    //validate actual and expected text
    Assert.assertEquals("'Customer Login' text not found ", expectedMessage, actualMessage);
}
    @After
    public void tearDown() {
        closeBrowser();
    }
}