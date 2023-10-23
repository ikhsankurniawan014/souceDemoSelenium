import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test //tag marking as runner to run the test below

    public void open_browser(){

        WebDriver driver; //define WebDriver with the name driver
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assert login page
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

    }

    @Test
    public void successfully_login(){

        WebDriver driver; //define WebDriver with the name driver
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assert login page
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        //Berinteraksi dengan element web
        //input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //klik button Login
        driver.findElement(By.id("login-button")).click();

        //Assert beranda page
        String berandaPage = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(berandaPage, "Products");

        driver.quit();
    }


    @Test
    public void unsuccessfully_login(){

        WebDriver driver; //define WebDriver with the name driver
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assert login page
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        //Berinteraksi dengan element web
        //input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input Password
        driver.findElement(By.id("password")).sendKeys("secret_ketchup");
        //klik button Login
        driver.findElement(By.id("login-button")).click();

        //Error message
        String errorMessage = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");





    }
}
