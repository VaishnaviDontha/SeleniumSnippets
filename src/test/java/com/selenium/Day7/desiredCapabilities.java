package com.selenium.Day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class desiredCapabilities {

    WebDriver driver;

    @Test
    public void Chrome() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/WebDriver/chromedriver");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName", "chrome");
        cap.setCapability("version", "100.0");
        cap.setCapability("platform", "win10");
        cap.setCapability("console", "true");

        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        
    }


    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
