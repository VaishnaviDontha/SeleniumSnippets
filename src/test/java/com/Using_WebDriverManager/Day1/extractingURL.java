package com.Using_WebDriverManager.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class extractingURL {
   
    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/"); 
        
    }

    @Test
    public void extractInfo() {

        // Grabbing info like - URL , Title , Page Source

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        
    }
}
