package com.Using_WebDriverManager.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class locatorsSE {

    /* LOCATORS

        1. id
        2. tagname
        3. xpath
        4. css selector
        5. classname
        6. name
        7. partialLinkText
        8. linkText

     */

    WebDriver driver;    

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
         
    }

    @Test
    public void locators() {

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='MP_link']")).getText());
        System.out.println(driver.findElement(By.tagName("body")).getText());
        System.out.println(driver.findElement(By.className("panelTrigger")).getText());
        
    }

    
    
}
