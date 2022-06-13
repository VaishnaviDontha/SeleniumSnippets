package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class penActions {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
    }

    @Test
    public void penAction() {

        WebElement pointerArea = driver.findElement(By.xpath("//a[text()='A/B Testing']"));
        
        new Actions(driver)
                .setActivePointer(PointerInput.Kind.PEN, "default pen")
                .moveToElement(pointerArea)
                .clickAndHold()
                .moveByOffset(2, 2)
                .release()
                .perform();
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
}
