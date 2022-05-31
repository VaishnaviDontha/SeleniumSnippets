package com.selenium.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class css {

    // Locators w.r.t the CSS selectors

    WebDriver driver;

    @BeforeTest
    public void BeforeTest() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://www.google.com/");
    
    }

    @Test
    public void cssLocators() throws InterruptedException {


        WebElement elem1 = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        elem1.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
        
        WebElement elem2 = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        elem2.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();


        driver.findElement(By.cssSelector("#gbqfbb")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        
        driver.findElement(By.cssSelector("input#gbqfbb")).click();
        Thread.sleep(5000);
        driver.navigate().back(); 


        WebElement elem3 = driver.findElement(By.cssSelector("[name='q']"));
        elem3.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
        
        WebElement elem4 = driver.findElement(By.cssSelector("input[name='q']"));
        elem4.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();

        // Tagname/Class/ID combination with attribute

        WebElement elem5 = driver.findElement(By.cssSelector("input.gLFyf.gsfi[name='q']"));
        elem5.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
        
        WebElement elem6 = driver.findElement(By.cssSelector(".gLFyf.gsfi[name='q']"));
        elem6.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.cssSelector("input#gbqfbb[role='button']")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        
        driver.findElement(By.cssSelector("#gbqfbb[role='button']")).click();
        Thread.sleep(5000);
        driver.navigate().back();

        // Substrings math - ^ $ * contains

        /* 
            input[id^=gbqf]
            input[id$=qfbb]
            input[id*=qfbb]


            a > span[class='ktLKi']
            div span[class='ktLKi']
            .KxwPGc.AghGtd a:nth-child(2)


        */

        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }

    
}
