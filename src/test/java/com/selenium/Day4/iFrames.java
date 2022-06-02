package com.selenium.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class iFrames {

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chromee.driver", "./resources/chromeddriver");
        driver.get("https://the-internet.herokuapp.com/frames");

    }

    @Test
    public void nestedFrames() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();

        // Using frame inside a frame strategy
        driver.switchTo().frame("frame-top"); // By Name
        driver.switchTo().frame("frame-left");
        String text = driver.findElement(By.xpath("//body")).getText();
        System.out.println(text);

        driver.switchTo().parentFrame(); // to revert to parent frame

        driver.navigate().back();
        
    }

    @Test
    public void iFrame() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//a[@href='/iframe']")).click();

        // iFrames 
        driver.switchTo().frame("mce_0_ifr"); // By ID
        driver.findElement(By.cssSelector("body p")).clear();

        driver.findElement(By.cssSelector("body p")).sendKeys("Testing iFrames");

        driver.switchTo().defaultContent(); // to comee out of frames

        String hText = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();

        System.out.println(hText);

        driver.navigate().back();

    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
