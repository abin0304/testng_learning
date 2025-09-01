package testngdemo1_demo;

import org.testng.Assert;
import org.testng.annotations.*;

public class Hellotestngtest {

    // Runs once before all test methods in this class
    @BeforeClass
    public void setupClass() {
        System.out.println(">>> BeforeClass");
    }

    // Runs once after all test methods in this class
    @AfterClass
    public void teardownClass() {
        System.out.println(">>> AfterClass");
    }

    // Runs before each @Test method
    @BeforeMethod
    public void setupMethod() {
        System.out.println("   > BeforeMethod");
    }

    // Runs after each @Test method
    @AfterMethod
    public void teardownMethod() {
        System.out.println("   > AfterMethod");
    }

    // A test case
    @Test
    public void testAddition() {
        int sum = 2 + 3;
        Assert.assertEquals(sum, 5, "Sum should be 5");
        System.out.println("      Test 1 executed");
    }

    // Another test case
    @Test
    public void testContains() {
        String s = "saucedemo";
        Assert.assertTrue(s.contains("sauce"), "Expected 'sauce' in string");
        System.out.println("      Test 2 executed");
    }
}
