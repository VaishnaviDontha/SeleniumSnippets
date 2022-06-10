package com.WebDriverManager.Day5;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchingInNewWindow {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
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

    @Test
    public void otherWaysofSwitchingTabs() {

        WebElement element = driver.findElement(By.cssSelector("a[href='/abtest']"));
        
        Actions act = new Actions(driver);
     
        act.keyDown(Keys.COMMAND)
            .click(element)
            .build()
            .perform();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switches to new Tab
        driver.switchTo().window(tabs.get(0)); // Switches to main Tab


        
    }


    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
