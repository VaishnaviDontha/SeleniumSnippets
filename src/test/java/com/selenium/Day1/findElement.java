package com.selenium.Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class findElement {


    WebDriver driver;

    @BeforeTest
    public void SetUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");   
    }

    @Test
    public void FindElement() {
        /* findElement 
        1. Used to find a single(first) element of the webpage
        2. Throws 'NoSuchElement Exception' when not Found */
        List<WebElement> ls = driver.findElements(By.id("txtUsername"));
        System.out.println(ls);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        
    }

    @Test
    public void FindElements() {

        /* findElements
        1. Used to grab more than one elements from a webpage
        2. returns List<WebElement>
        3. Can be returned in List or Array format
        4. if No elements returns empty
        5. returns whole list of all(not all but all the elements which are loaded by that time) the elements matching the specified locator.
        */ 

        driver.findElements(By.id("txtUsername")).get(0).sendKeys("Admin");

        // Above statement acts similar to findelement 
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        
    }

    
}
