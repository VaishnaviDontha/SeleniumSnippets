package com.WebDriverManager.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class clear {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://the-internet.herokuapp.com/inputs");     
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
        
    }

    @Test
    public void clearData() throws InterruptedException {

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("input[type='number']")).clear();
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
