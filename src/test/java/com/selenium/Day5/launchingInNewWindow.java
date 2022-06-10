package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class launchingInNewWindow {
   
    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
    }

    @Test
    public void openingLinkInNewWindow() throws InterruptedException {

        WebElement element = driver.findElement(By.cssSelector("a[href='/abtest']"));
        
        Actions act = new Actions(driver);
        act.keyDown(Keys.SHIFT)
            .click(element)
            .build()
            .perform();
        
    }


    @Test 
    public void openingLinkInNewTab() throws InterruptedException {

        WebElement element = driver.findElement(By.cssSelector("a[href='/abtest']"));
        
        Actions act = new Actions(driver);
        act.keyDown(Keys.COMMAND)
            .click(element)
            .build()
            .perform();
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
}
