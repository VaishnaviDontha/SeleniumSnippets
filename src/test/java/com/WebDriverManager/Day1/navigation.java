package com.WebDriverManager.Day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigation {

    /*
     * Navigation helps user to move back, forth, refresh and navigate to a
     * respective URL
     * via navigate()
     * navigate().to() = Allows user to navigate to a particular page
     * navigate().back() = Back
     * navigate().forward() = Forward
     * navigate().refresh() = Refresh
     * navigate().to(URL url) = Overloading to() method
     */

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void NavigateTo() throws MalformedURLException {
        driver.navigate().to("https://www.google.com/");

        // Overloading to(URL url)

        driver.navigate().to(new URL("https://www.gmail.com"));

    }

    @Test
    public void NavigateBack() {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("MP_link")).click();
        driver.navigate().back();

        System.out.println(driver.getCurrentUrl());
        
    }

    @Test
    public void NavigateForward() {

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        
    }


    @Test
    public void Refresh() {

        driver.navigate().refresh();

        // Other different ways to refresh

        driver.navigate().to(driver.getCurrentUrl());
        driver.get(driver.getCurrentUrl());
        driver.findElement(By.tagName("body")).sendKeys(Keys.SHIFT);
        
    }


}
