package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class scrollwheelActions {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }


    
}
