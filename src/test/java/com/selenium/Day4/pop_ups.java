package com.selenium.Day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class pop_ups {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");
        
    }

    @Test
    public void auth() {

        // Auth Pop-Up
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
        String eText = driver.findElement(By.cssSelector("div[id='content'] p")).getText();
        System.out.println(eText);

        driver.navigate().back();
        
    }

    @Test
    public void modal_win() {

        driver.get("https://the-internet.herokuapp.com/entry_ad");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

        driver.findElement(By.xpath("//p[text()='Close']")).click();
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
