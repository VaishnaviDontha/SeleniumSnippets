package com.WebDriverManager.Day5;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class submit {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        
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
