package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class submit {
    
    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/login");     
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        
    }

    @Test
    public void clearData() {

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!"); 
        
        driver.findElement(By.cssSelector("button[type='submit']")).submit();
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    } 
}
