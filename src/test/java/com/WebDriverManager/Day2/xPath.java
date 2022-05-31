package com.WebDriverManager.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xPath {

    /*
     * Two Types :
     * 1. Absolute xPath - Starts with '/' e.g: /html/head/body/div/input/
     * 2. Relative XPath - Represented by '//'
     */

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://www.google.com/");

    }

    @Test
    public void absouluteXpath() {
        // navigates to gmail
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
        driver.navigate().back();

    }

    @Test
    public void relativeXpath() throws InterruptedException {

        //driver.navigate().to("https://www.google.com/");
        
        WebElement elem = driver.findElement(By.xpath("//input[@name='q']")); // Relative XPath
        elem.sendKeys("Selenium",Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("(//a[contains(@class,'MV3Tnb')])[1]")).click(); // Relative XPath with contains and Index number
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("//span[text()='Carbon neutral since 2007']")).click(); // Relative Xpath with Text
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("//span[starts-with(text(),'Carbon')]")).click(); // Relative Xpath with starts-with
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("//span[starts-with(text(),'Carbon')]")).click(); // Relative Xpath with starts-with
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("//a[@class='pHiOh'][contains(.,'Advertising')]")).click(); // Relative Xpath with contains
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("//div[@class='rIbAWc']//div[text()='Settings']")).click(); // Relative Xpath with Chained 
        Thread.sleep(5000);
        driver.navigate().back();

    }

    @Test
    public void xPathAxes() throws InterruptedException {

        driver.findElement(By.xpath("//a[@class='pHiOh']//following::a[text()='Terms']")).click(); // Relative Xpath with Following
        Thread.sleep(5000);
        driver.navigate().back();

        driver.findElement(By.xpath("//div[@class='rIbAWc']/div[text()='Settings']")).click(); // Relative Xpath with Parent reference
        Thread.sleep(5000);
        driver.navigate().back();
        
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        
    }

    

}
