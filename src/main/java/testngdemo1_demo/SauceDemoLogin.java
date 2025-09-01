package testngdemo1_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLogin {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        System.out.println(">>> BeforeClass: Setup WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardownClass() {
        System.out.println(">>> AfterClass: Close browser");
        if(driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("   > BeforeMethod: Navigate to saucedemo login page");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardownMethod() {
        System.out.println("   > AfterMethod: Cleanup after test");
        // Clear username and password fields if needed
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
    }

    // ✅ Test case 1: Valid login
    @Test
    public void testValidLogin() {
        System.out.println("      Executing testValidLogin");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Assertion: check URL or presence of inventory page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "User should land on inventory page");
    }

    // ✅ Test case 2: Invalid login
    @Test
    public void testInvalidLogin() {
        System.out.println("      Executing testInvalidLogin");
Utils.waitFor(5000);
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
        driver.findElement(By.id("login-button")).click();

        // Assertion: error message should appear
        String errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(errorMsg.contains("Username and password do not match"), "Error message should appear");
    }
}
