package com.WebDriverManager.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class passingData {

    /*
     * Passing data into a form without using sendkeys -
     * This can be done via JavaScript Executor
     */

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void JSExecutor() {

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        // WebElement Uname = driver.findElement(By.id("username"));
        // Uname.sendKeys("tomsmith");
        jse.executeScript("document.getElementById('username').value = 'tomsmith' ; ");

        jse.executeScript("document.getElementById('password').value = 'SuperSecretPassword!' ; ");

        // WebElement Pwd = driver.findElement(By.id("password"));
        // Pwd.sendKeys("SuperSecretPassword!");

        // jse.executeScript("SuperSecretPassword!", Pwd);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @AfterTest
    public void tearDown() {

        driver.close();

    }
}
