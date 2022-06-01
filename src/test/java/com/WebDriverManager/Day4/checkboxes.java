package com.WebDriverManager.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class checkboxes {

    WebDriver driver;

    @BeforeTest
    public void Setup() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void checkbox() {

        if(! driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected()){

            driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        }

        else 

            driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click(); 
        
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
