package com.selenium.Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class css {

    // Locators w.r.t the CSS selectors

    WebDriver driver;

    @BeforeTest
    public void BeforeTest() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    
    }

    @Test
    public void idLocator() {

        // 'input' element with @id = txtUsername :: input#txtUsername
        driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");

        // any element with @id = txtPassword :: #txtPassword
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");

        
    }

    @Test
    public void classLocator() {

        // 'input' element with @class = button :: input.button
        driver.findElement(By.cssSelector("input.button")).click(); 
        
        // any element with @class = head :: .head
        String txt  = driver.findElement(By.cssSelector(".head")).getText();
        System.out.println(txt);
        
    }
    
}
