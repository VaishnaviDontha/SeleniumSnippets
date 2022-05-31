package com.WebDriverManager.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class closeAndQuit {

    WebDriver driver;

    @Test
    public void ChromeBrowser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // driver.close();
        driver.quit();

    }
    
}
