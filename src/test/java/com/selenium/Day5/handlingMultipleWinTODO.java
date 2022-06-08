package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class handlingMultipleWinTODO {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        
        driver = new ChromeDriver();
        
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void multipleWindows() {

        String parentGUID = driver.getWindowHandle();
        System.out.println(parentGUID);
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
