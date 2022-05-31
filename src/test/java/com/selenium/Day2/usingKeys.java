package com.selenium.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class usingKeys {


    /* 
    Activities done through KeyBoard
        1. Refresh
        2. Passing Data
        3. Passing multiple data via Strings
        4. Using Keys.keys 
        5. Erasing Text
        6. Performing Click
        7. Submit 
    */

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
    }

    @Test
    public void refreshViaKeys() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.COMMAND,"R");
        
    }

    @Test
    public void passingData() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("test");
        
    }

    @Test
    public void multipleData() {

        driver.get("https://google.com");
		// strings
		String[] strings = {"str1", "str2", "str3"};
		driver.findElement(By.name("q")).sendKeys(strings);
        
    }

    @Test
    public void erasingData() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).clear();
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();

        // driver.close();
        
    } 
        
    
}
