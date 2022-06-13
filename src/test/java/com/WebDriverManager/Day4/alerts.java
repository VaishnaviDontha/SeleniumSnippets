package com.WebDriverManager.Day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class alerts {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
    }

    @Test
    public void alert() {

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.cssSelector("p[id = result]")).getText());

        // Dismiss
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();;
        driver.switchTo().alert().dismiss();

        // confirm
        driver.findElement(By.cssSelector("button[onclick = 'jsConfirm()']")).click();;
        driver.switchTo().alert().accept();

        // dismiss confirmation box
        driver.findElement(By.cssSelector("button[onclick = 'jsConfirm()']")).click();;
        driver.switchTo().alert().dismiss();
        
        // Send keys
        driver.findElement(By.cssSelector("button[onclick = 'jsPrompt()']")).click();
        Alert ale = driver.switchTo().alert();
        ale.sendKeys("Keys");
        ale.accept();

        // dismiss text box
        driver.findElement(By.cssSelector("button[onclick = 'jsPrompt()']")).click();
        driver.switchTo().alert().dismiss();        
        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

        // driver.close();
        
    }
    
}
