package com.WebDriverManager.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboardActions {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
    }

    @Test
    public void keys() {

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(Keys.NUMPAD0);
        // driver.findElement(By.cssSelector("input[type='text'])")).clear();
    }

    @Test
    public void keyDown() {

        WebElement elem = driver.findElement(By.cssSelector("input[type='text']"));
        Actions act = new Actions(driver);
        act.keyDown(elem, Keys.SHIFT)
        .sendKeys("a").build().perform();

    }

    @Test
    public void keyUp() {

        WebElement elem = driver.findElement(By.cssSelector("input[type='text']"));
        Actions act = new Actions(driver);
        act.keyUp(elem, Keys.SHIFT)
        .sendKeys("b").perform();

    }

    @Test
    public void sendKeys() {

        WebElement elem = driver.findElement(By.cssSelector("input[type='text']"));
        Actions act = new Actions(driver);
        act.sendKeys(elem, "cd")
        .perform();

    }

    @Test
    public void copyPasteAction() {

        WebElement elem = driver.findElement(By.cssSelector("input[type='text']"));

        String platformName = "MAC";   
        Keys cmdCtrl = platformName.equals("MAC") ? Keys.COMMAND : Keys.CONTROL;
        
        new Actions(driver)
                .sendKeys(elem, "Se")
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("xvv")
                .keyUp(cmdCtrl)
                .perform();

    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
