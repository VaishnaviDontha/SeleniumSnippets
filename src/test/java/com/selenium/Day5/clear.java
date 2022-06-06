package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class clear {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
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
