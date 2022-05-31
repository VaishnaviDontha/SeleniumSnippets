package com.selenium.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class clickAndsubmit {

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/login");

    }

    @Test
    public void click() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        driver.navigate().back();

    }

    @Test
    public void submit() {
        WebElement cl = driver.findElement(By.id("username")); 
        cl.clear(); 
        cl.sendKeys("tomsmith");
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.clear();        
        pwd.sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).submit();
        
    }

    @AfterTest
    public void tearDown() {
        driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();
        driver.quit();

        // driver.close();
        
    }



}
