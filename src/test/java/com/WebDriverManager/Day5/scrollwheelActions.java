package com.WebDriverManager.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrollwheelActions {
   
    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/large");

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @Test
    public void scrollToAElement() {

        WebElement elem = driver.findElement(By.xpath("//div[text()='50.2']"));
        new Actions(driver).scrollToElement(elem).perform();

        System.out.println(elem.getText());
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
}
