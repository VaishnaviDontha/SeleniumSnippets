package com.selenium.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class relativeLocators {

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");

    }

    @Test
    public void relativeLocators() {

        // driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.findElement(RelativeLocator.with(By.xpath("//a[@href='/login']")).below(By.cssSelector("a[href='/forgot_password']"))).click();
        driver.findElement(RelativeLocator.with(By.cssSelector("input[type='text']")).above(By.cssSelector("input[type='password']"))).sendKeys("Admin");
        
        driver.navigate().to("https://www.google.com/");

        driver.findElement(RelativeLocator.with(By.xpath("//a[text()='About']")).toRightOf(By.className("//a[text()='Store']"))).click();
        driver.navigate().back();

        driver.findElement(RelativeLocator.with(By.xpath("//a[text()='Store']")).toLeftOf(By.className("//a[text()='About']"))).click();
        driver.navigate().back();

        driver.findElement(RelativeLocator.with(By.xpath("//a[text()='Images']")).near(By.xpath("//a[text()='Gmail']"))).click();
        driver.navigate().back();

        driver.findElement(RelativeLocator.with(By.xpath("//a[text()='Business']")).below(By.className(".ktLKi")).toLeftOf(By.className("//a[@class='pHiOh'][3]"))).click();
        
    }

   @Test
    public void TearDown() {
        driver.quit();

        // driver.close();
        
    }
    
}
