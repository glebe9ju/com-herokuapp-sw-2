package testsuite;
/*
Create the package ‘testsuite’ and create the following
class inside the ‘testsuite’ package.

1. LoginTest
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginWithValidCredential(){

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        WebElement login = driver.findElement(By.className("radius"));
        login.click();
        WebElement secureArea = driver.findElement(By.xpath("//div[@class='example']//h2"));
        System.out.println(secureArea.getText());
        //Verify the text “Secure Area”
        Assert.assertEquals("Incorrect Login detail" , "Secure Area",secureArea.getText());
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
       // Enter “tomsmith1” username
        WebElement invalidUserName = driver.findElement(By.name("username"));
        invalidUserName.sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.className("radius"));
        login.click();
        WebElement invalidUserName1 = driver.findElement(By.id("flash"));
        System.out.println(invalidUserName1.getText());
        //Verify the error message “Your username is invalid!”
        Assert.assertEquals("Incorrect login detail","Your username is invalid!\n×",invalidUserName1.getText());

    }
        @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        WebElement validUserName = driver.findElement(By.name("username"));
        validUserName.sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        WebElement invalidPassWord = driver.findElement(By.id("password"));
        invalidPassWord.sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.className("radius"));
        login.click();
        //Verify the error message “Your password is invalild!"
        WebElement invalidPassWor = driver.findElement(By.id("flash"));
        System.out.println(invalidPassWor.getText());
        Assert.assertEquals("Incorrect password","Your password is invalid!\n×",invalidPassWor.getText());

    }
    @After
    public void tearDown() {
        closeBrowsers();
    }
}
