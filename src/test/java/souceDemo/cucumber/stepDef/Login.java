package souceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver; //define WebDriver with the name driver

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Login page was showed")
        public void login_page_was_showed(){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get(baseUrl);

            //Assert login page
            String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
            Assert.assertEquals(loginPageAssert, "Swag Labs");
        }


    @When("Input correct username")
    public void input_correct_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("Input wrong username")
    public void input_wrong_username() {
        driver.findElement(By.id("user-name")).sendKeys("root");
    }

    @And("Input correct password")
    public void input_correct_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Input wrong password")
    public void input_wrong_password() {
            driver.findElement(By.id("password")).sendKeys("secret_ketchup");
    }

    @And("Click button Login")
    public void click_button_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User redirect to beranda page")
    public void user_redirect_to_beranda_page() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String beranda = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(beranda, "Products");
        driver.quit();
    }

    @Then("User get an error message")
    public void user_get_an_error_message() {
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @Then("User get an error message input tidak ada")
    public void user_get_an_error_message_input_tidak_ada() {
        String errorLoginInputKosong = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username is required')]")).getText();
        Assert.assertEquals(errorLoginInputKosong, "Epic sadface: Username is required");
    }
}
