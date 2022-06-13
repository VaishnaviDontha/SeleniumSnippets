package com.WebDriverManager.Day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class colors {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
    }

    @Test
    public void testsWithColors() {

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        String loginButton = Color.fromString(driver.findElement(By.id("login")).getCssValue("color")).asHex();


        Assert.assertEquals(loginButton, "#222222");
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
