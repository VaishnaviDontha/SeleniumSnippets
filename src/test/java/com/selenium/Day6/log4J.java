package com.selenium.Day6;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class log4J {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/login");
        
    }

    public void log4j() {

        

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("tomsmith");
        
        driver.findElement(By.xpath("//input[type='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).submit();

        
    }

    @Test
    public void log4jWithPropertiesFile() {

        // Logger log = Logger.getLogger(log4J.class.getName());
        
    }
    
}
