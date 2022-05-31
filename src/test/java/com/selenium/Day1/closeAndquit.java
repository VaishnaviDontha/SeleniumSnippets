package com.selenium.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class closeAndquit {

    WebDriver driver;


    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        
    }

    @Test
    public void CloseBrowser() {
        // Opening a new tab to view the functionality of Closing a Browser
        
        driver.findElement(By.xpath("//img[@name='img_cart']")).click();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();        
        driver.close();
        
    }

    @Test
    public void QuitBrowser() {
        driver.quit();
        // driver.close();
        
    }
    
}
