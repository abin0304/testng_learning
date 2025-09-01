package testngdemo1_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoProductCheckout {
	
	WebDriver driver;

    @BeforeClass
    public void setupClass(){
//        System.out.println(">>> BeforeClass: Setup WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
    }

    @AfterClass
    public void teardownClass() {
//        System.out.println(">>> AfterClass: Close browser");
        if(driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void setupMethod() {
//        System.out.println("   > BeforeMethod: Navigate to saucedemo login page");
        driver.get("https://www.saucedemo.com/");
        Utils.waitFor(2000);
        
    }

    @AfterMethod
    public void teardownMethod() {
        System.out.println("Log out");
        // Clear username and password fields if needed
        Utils.waitFor(2000);
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        Utils.waitFor(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Utils.waitFor(1000);
        driver.findElement(By.id("user-name")).clear();
        Utils.waitFor(1000);
        driver.findElement(By.id("password")).clear();
    }
    
    @Test
    public void testValidLogin() {
//        System.out.println("      Executing testValidLogin");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Utils.waitFor(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Utils.waitFor(1000);
        driver.findElement(By.id("login-button")).click();
        Utils.waitFor(1000);

        // Assertion: check URL or presence of inventory page
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue(currentUrl.contains("inventory.html"), "User should land on inventory page");
    }
}
