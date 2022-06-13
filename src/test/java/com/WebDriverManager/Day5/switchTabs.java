package com.WebDriverManager.Day5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

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


public class switchTabs {

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
    public void switchTwoDiffTabs() throws InterruptedException {

        Set<String> allGUID = driver.getWindowHandles();
        String pGUID = driver.getWindowHandle();
        System.out.println(pGUID);
        
        WebElement element = driver.findElement(By.cssSelector("a[href='/abtest']"));
        
        Actions act = new Actions(driver);
        act.keyDown(Keys.COMMAND)
            .click(element)
            .build()
            .perform();

        for(String guid : allGUID){

            if(guid.equals(pGUID)){
                driver.switchTo().window(pGUID);
                System.out.println(pGUID);
                break;
            }
        }

    }

    @Test
    public void switchMultipleDiffTabs() throws InterruptedException {
        
        WebElement element = driver.findElement(By.cssSelector("a[href='/abtest']"));
        
        Actions act = new Actions(driver);
        act.keyDown(Keys.COMMAND)
            .click(element)
            .build()
            .perform();

        WebElement element1 = driver.findElement(By.cssSelector("a[href='/add_remove_elements/']"));
        
        Actions act1 = new Actions(driver);
        act1.keyDown(Keys.COMMAND)
            .click(element1)
            .build()
            .perform();

        WebElement element2 = driver.findElement(By.cssSelector("a[href='/broken_images']"));
        
        Actions act2 = new Actions(driver);
        act2.keyDown(Keys.COMMAND)
            .click(element2)
            .build()
            .perform();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));

    }
    
    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
}
