package com.WebDriverManager.Day5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class click {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");     
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        
    }

    @Test
    public void clearData() throws InterruptedException {

        for (int i = 1; i <= 4; i++) {

            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            
        }

        List<WebElement> elements = driver.findElements(By.xpath("//button[text()='Delete']")); 
        System.out.println(elements.size());

    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
