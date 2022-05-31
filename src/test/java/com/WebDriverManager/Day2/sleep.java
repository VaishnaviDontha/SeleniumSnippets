package com.WebDriverManager.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sleep {

    // referred also as blindwait, deadwait, static wait

    WebDriver driver;
    
    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void Sleep() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        Thread.sleep(10000); // waits for 10000 ms
        driver.findElement(By.className("radius")).click();
        
    }

    @AfterTest
    public void tearDown() {

        driver.close();
        
    }
}
