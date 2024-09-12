package StepDefination;
 
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class LoginSteps {
    WebDriver driver;
 
    @Given("I am on the Swag Labs login page")
    public void i_am_on_the_swag_labs_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
 
    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
    }
 
    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("invalid_user");
        password.sendKeys("invalid_sauce");
    }
 
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
 
    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            throw new AssertionError("Login failed");
        }
        driver.quit();
    }
 
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        if (!errorMessage.isDisplayed()) {
            throw new AssertionError("Error message not displayed");
        }
        driver.quit();
    }
}